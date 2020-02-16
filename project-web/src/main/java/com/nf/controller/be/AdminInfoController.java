package com.nf.controller.be;

import com.nf.entity.AdminInfo;
import com.nf.entity.NodeInfo;
import com.nf.service.AdminInfoService;
import com.nf.service.NodeInfoService;
import com.nf.vo.AdminRoleNodeVO;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {
    @Autowired
    private AdminInfoService adminInfoService;
    @Autowired
    private NodeInfoService nodeInfoService;

    @PostMapping("/login")
    public ResponseVO login(@Valid @RequestBody AdminInfo adminInfo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseVO.builder().code("500").msg("校验失败").build();
        }

        AdminInfo admin = adminInfoService.getByUserName(adminInfo.getUserName());
        if (admin!=null){
            if (admin.getUserName().equals(adminInfo.getUserName()) && admin.getPassWord().equals(adminInfo.getPassWord())) {
                //查询该用户的所有能访问的路由
                List<NodeInfo> routes = nodeInfoService.getNodeByAdminId(admin.getId());
                //获得菜单
                List<NodeInfo> menus = generateMenus(routes);
                //vo打包把用户信息,角色信息,节点信息
                AdminRoleNodeVO result = new AdminRoleNodeVO();
                result.setAdminInfo(admin);
                result.setRoutes(routes);
                result.setMenus(menus);

                return ResponseVO.builder().code("200").msg("登录成功").data(result).build();
            }
        }
        return ResponseVO.builder().code("500").msg("登录失败").build();
    }

    /**
     * 产生节点（目录）
     * @param nodes
     * @return
     */
    private List<NodeInfo> generateMenus(List<NodeInfo> nodes){
        List<NodeInfo> menus = new ArrayList<>();
        for (NodeInfo node : nodes) {
            if(node.getPid().equals(0)){
                 menus.add(setChild(node,nodes));
            }
        }
        return menus;
    }

    /**
     * 产生子节点
     * @param nodeInfo
     * @param nodes
     * @return
     */
    private NodeInfo setChild(NodeInfo nodeInfo, List<NodeInfo> nodes){
        List<NodeInfo> menus = new ArrayList<>();
        for (NodeInfo node : nodes) {
            if(node.getPid().equals(nodeInfo.getId())){
                menus.add(node);
            }
        }
        nodeInfo.setChild(menus);
        return nodeInfo;
    }

}

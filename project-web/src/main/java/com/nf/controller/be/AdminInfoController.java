package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.entity.AdminInfo;
import com.nf.entity.NodeInfo;
import com.nf.service.AdminInfoService;
import com.nf.service.NodeInfoService;
import com.nf.service.RoleInfoService;
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
    @Autowired
    private RoleInfoService roleInfoService;

    @GetMapping("/getByRoleId")
    public ResponseVO getByRoleId(Integer pageNum,Integer pageSize,Integer roleId) {
        PageInfo result = new PageInfo(adminInfoService.getByRoleId(pageNum,pageSize,roleId));
        return ResponseVO.builder().code("200").data(result).build();
    }
    @GetMapping("/getAll")
    public ResponseVO getAll(Integer pageNum,Integer pageSize) {
        PageInfo result = new PageInfo(adminInfoService.getAll(pageNum,pageSize));
        return ResponseVO.builder().code("200").data(result).build();
    }

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
                List<NodeInfo> menus = generateNode(routes,0);
                //获得该用户权力最大的角色
                String position = roleInfoService.getMaxName(admin.getId());
                //vo打包把用户信息,角色信息,节点信息
                AdminRoleNodeVO result = new AdminRoleNodeVO();
                result.setAdminInfo(admin);
                result.setRoutes(routes);
                result.setMenus(menus);
                result.setPosition(position);

                return ResponseVO.builder().code("200").msg("登录成功").data(result).build();
            }
        }
        return ResponseVO.builder().code("500").msg("登录失败").build();
    }

    /**
     * 产生节点（目录）
     * @return
     */
    private List<NodeInfo> generateNode(List<NodeInfo> nodes,Integer pid){
        List<NodeInfo> result = new ArrayList<>();
        for (NodeInfo node : nodes) {
            if(node.getPid().equals(pid)){
                result.add(node);
                List<NodeInfo> child = generateNode(nodes,node.getId());
                node.setChild(child);
            }
        }
        return result;
    }

//    /**
//     * 产生节点（目录）
//     * @param nodes
//     * @return
//     */
//    private List<NodeInfo> generateMenus(List<NodeInfo> nodes){
//        List<NodeInfo> menus = new ArrayList<>();
//        for (NodeInfo node : nodes) {
//            if(node.getPid().equals(0)){
//                 menus.add(setChild(node,nodes));
//            }
//        }
//        return menus;
//    }
//
//    /**
//     * 产生子节点
//     * @param nodeInfo
//     * @param nodes
//     * @return
//     */
//    private NodeInfo setChild(NodeInfo nodeInfo, List<NodeInfo> nodes){
//        List<NodeInfo> menus = new ArrayList<>();
//        for (NodeInfo node : nodes) {
//            if(node.getPid().equals(nodeInfo.getId())){
//                menus.add(node);
//            }
//        }
//        nodeInfo.setChild(menus);
//        return nodeInfo;
//    }

}

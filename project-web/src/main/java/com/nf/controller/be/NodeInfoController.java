package com.nf.controller.be;

import com.nf.entity.NodeInfo;
import com.nf.service.NodeInfoService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NodeInfoController {
    @Autowired
    private NodeInfoService nodeInfoService;

    @GetMapping("/node")
    public ResponseVO getAll(){
        List<NodeInfo> result = nodeInfoService.getAll();
        result = generateNode(result,0);

        return ResponseVO.builder().code("200").data(result).build();
    }

    @GetMapping("/node/byRoleId")
    public ResponseVO getByRoleId(Integer roleId){
        List<NodeInfo> result = nodeInfoService.getByRoleId(roleId);
        return ResponseVO.builder().code("200").data(result).build();

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
}

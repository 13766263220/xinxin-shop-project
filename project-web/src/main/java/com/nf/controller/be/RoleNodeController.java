package com.nf.controller.be;

import com.nf.entity.RoleNode;
import com.nf.service.RoleNodeService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleNodeController {
    @Autowired
    private RoleNodeService roleNodeService;

    @PostMapping("/roleNode")
    public ResponseVO authorization(@RequestBody List<RoleNode> roleNodes){
        roleNodeService.authorization(roleNodes);
        return ResponseVO.builder().code("200").msg("授权成功").build();
    }
}

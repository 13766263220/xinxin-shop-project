package com.nf.controller.be;

import com.nf.dao.RoleAdminDao;
import com.nf.entity.RoleAdmin;
import com.nf.service.RoleAdminService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoleAdminController {
    @Autowired
    private RoleAdminService roleAdminService;

    @PostMapping("/roleAdminDel")
    public ResponseVO delRoleAdmin(@RequestBody RoleAdmin roleAdmin) {
        roleAdminService.delRoleAdmin(roleAdmin);
        return ResponseVO.builder().code("200").msg("删除成功").build();
    }

    @PostMapping("/roleAdmin")
    public ResponseVO addRoleAdmin(@RequestBody RoleAdmin roleAdmin) {
        roleAdminService.addRoleAdmin(roleAdmin);
        return ResponseVO.builder().code("200").msg("添加成功").build();
    }
}

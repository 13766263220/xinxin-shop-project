package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.entity.RoleInfo;
import com.nf.service.RoleInfoService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleInfoController {
    @Autowired
    private RoleInfoService roleInfoService;

    @GetMapping("/role/{pageNum}-{pageSize}")
    public ResponseVO getAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize,RoleInfo roleInfo){

        PageInfo result = new PageInfo(roleInfoService.getAll(pageNum,pageSize,roleInfo));
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/role")
    public ResponseVO addRoleInfo(@RequestBody RoleInfo roleInfo) {
        roleInfoService.addRoleInfo(roleInfo);
        return ResponseVO.builder().code("200").msg("添加成功").build();
    }

    @DeleteMapping("/role/{id}")
    public ResponseVO deleteById(@PathVariable Integer id) {
        boolean resultBool = roleInfoService.deleteById(id);
        if(resultBool) {
            return ResponseVO.builder().code("200").msg("删除成功").build();
        }
        return ResponseVO.builder().code("500").msg("删除失败").build();
    }

    @PutMapping("/role")
    public ResponseVO editRoleInfo(@RequestBody RoleInfo roleInfo) {
        roleInfoService.editRoleInfo(roleInfo);
        return ResponseVO.builder().code("200").msg("修改成功").build();
    }
}

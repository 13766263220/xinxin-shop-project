package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.entity.RoleInfo;
import com.nf.service.RoleInfoService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleInfoController {
    @Autowired
    private RoleInfoService roleInfoService;

    @GetMapping("/role/{pageNum}-{pageSize}")
    public ResponseVO getAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        PageInfo result = new PageInfo(roleInfoService.getAll(pageNum,pageSize));
        return ResponseVO.builder().code("200").data(result).build();
    }

    
}

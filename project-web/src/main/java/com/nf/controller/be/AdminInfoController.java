package com.nf.controller.be;

import com.nf.entity.AdminInfo;
import com.nf.service.AdminInfoService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

//设置跨域
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {

    @Autowired
    private AdminInfoService adminInfoService;

    @PostMapping("/login")
    public ResponseVO login(@Valid @RequestBody AdminInfo adminInfo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseVO.builder().code("500").msg("校验失败").build();
        }

        AdminInfo admin = adminInfoService.getByUserName(adminInfo.getUserName());
        if (admin!=null){
            if (admin.getUserName().equals(adminInfo.getUserName()) && admin.getPassWord().equals(adminInfo.getPassWord())) {

                return ResponseVO.builder().code("200").msg("登录成功").data(admin).build();
            }
        }
        return ResponseVO.builder().code("500").msg("登录失败").build();
    }

}

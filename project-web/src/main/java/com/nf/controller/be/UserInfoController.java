package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.entity.UserInfo;
import com.nf.service.UserInfoService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/userInfo/{pageNum}-{pageSize}")
    public ResponseVO getAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize, UserInfo userInfo) {
        PageInfo result = new PageInfo(userInfoService.getAll(pageNum,pageSize,userInfo));
        return ResponseVO.builder().code("200").msg("ok").data(result).build();
    }


//    @GetMapping("/userInfo/{phone}")
//    public UserInfo getByPhone(@PathVariable String phone) {
//        System.out.println(phone);
//        //return userInfoService.getByPhone(phone);
//        return null;
//    }

    @DeleteMapping("/userInfo/{id}")
    public void deleteById(@PathVariable Integer id) {
        //userInfoService.deleteById(id);
        System.out.println(id);

    }

    @PutMapping("/userInfo")
    public ResponseVO editUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.editUserInfo(userInfo);
        return ResponseVO.builder().code("200").msg("ok").build();
    }

    public void insertUserInfo(UserInfo userInfo) {
        userInfoService.insertUserInfo(userInfo);
    }
}

package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.dto.UserInfoDTO;
import com.nf.entity.UserInfo;
import com.nf.service.UserInfoService;
import com.nf.utils.JwtUtil;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 查看所有用户
     * @param pageNum
     * @param pageSize
     * @param userInfo
     * @return
     */
    @GetMapping("/userInfo/{pageNum}-{pageSize}")
    public ResponseVO getAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize, UserInfo userInfo) {
        PageInfo result = new PageInfo(userInfoService.getAll(pageNum,pageSize,userInfo));
        return ResponseVO.builder().code("200").msg("ok").data(result).build();
    }

    /**
     * 用户登录
     * @param phone
     * @return
     */
    @GetMapping("/userInfo/login/{phone}")
    public ResponseVO login(@PathVariable String phone,String password) throws Exception {
        UserInfo userInfo = userInfoService.getByPhone(phone);

        if(userInfo == null){
            return ResponseVO.builder().code("500").msg("账号或密码错误").build();
        }

        //判断该用户是否被禁用
        if(userInfo.getStatus().equals(0)){
            return ResponseVO.builder().code("500").msg("该账号已被管理员禁用,无法使用").build();
        }


        if(password.equals(userInfo.getPassWord())){

            //使用jwt生成token
           String token = JwtUtil.createJWT(userInfo.getPhone(),30*60*1000); //分*秒*毫秒 30分钟过期

            return ResponseVO.builder().code("200").msg("登录成功").data(token).build();
        }
        return ResponseVO.builder().code("500").msg("账号或密码错误").build();
    }

    /**
     * 查询用户信息
     * @param token
     * @return
     * @throws Exception
     */
    @GetMapping("/userInfo/info")
    public ResponseVO getUserInfo(String token) {

        String phone = null;
        try {
            phone = JwtUtil.parseJWT(token).getSubject();
        } catch (Exception e) {
            return ResponseVO.builder().code("403").msg("请跳转到登录界面").build();
        }
        UserInfo userInfo = userInfoService.getByPhone(phone);
        return ResponseVO.builder().code("200").msg("查询成功").data(userInfo).build();
    }

    @DeleteMapping("/userInfo/{id}")
    public void deleteById(@PathVariable Integer id) {
        //userInfoService.deleteById(id);
        System.out.println(id);

    }

    @PutMapping("/userInfo")
    public ResponseVO editUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        if("user".equals(userInfoDTO.getRole())){
            try {
                String phone = JwtUtil.parseJWT(userInfoDTO.getToken()).getSubject();
            } catch (Exception e) {
                return ResponseVO.builder().code("403").msg("请跳转到登录界面").build();
            }
        }

        userInfoService.editUserInfo(userInfoDTO.getUserInfo());
        return ResponseVO.builder().code("200").msg("编辑成功").build();
    }

    @PostMapping("/userInfo/insert")
    public ResponseVO insertUserInfo(@RequestBody UserInfo userInfo) {
        userInfo.setStatus(1);
        userInfo.setRegistrationTime(new Date());
        userInfoService.insertUserInfo(userInfo);
        return ResponseVO.builder().code("200").msg("添加成功").build();
    }

    @PostMapping("/userInfo/isDoLogin")
    public ResponseVO isDoLogin(String token){
        try {
            JwtUtil.parseJWT(token).getSubject();
        } catch (Exception e) {
            return ResponseVO.builder().code("403").msg("请跳转到登录界面").build();
        }

        return ResponseVO.builder().code("200").msg("用户已登录").build();
    }

}

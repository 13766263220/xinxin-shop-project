package com.nf.controller;

import com.nf.utils.CodecUtil;
import com.nf.utils.SendSmsUtils;
import com.nf.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生成验证码
 */
@RestController
@RequestMapping("/verificationCode")
public class VerificationCodeController {
    @RequestMapping("/generateCode")
    public ResponseVO generateCode(String phone){
        String code = SendSmsUtils.generateCode();
        //SendSmsUtils.sendCode(code,phone);
        return ResponseVO.builder().code("200").msg("发送成功").data(code).build();
    }
}

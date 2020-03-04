package com.nf.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.rmi.ServerException;
import java.util.Random;

public class SendSmsUtils {
    private static final String accessKeyId = "LTAI4FcY199A6JghazLxruqV";//阿里云账号
    private static final String accessSecret = "SlFwCY9cglQAalpeKAK2zjdnnE1wx9";//阿里云密码

    /**
     * 发送验证码
     * @param code 验证码
     * @param phone 电话号码
     * @return
     */
    public static String sendCode(String code,String phone){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "欣欣商城");
        request.putQueryParameter("TemplateCode", "SMS_184820159");
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getData();
    }

    /**
     * 生成随机数验证码
     * @return
     */
    public static String generateCode(){
        Double randomCode = Math.random();
        String randomCodeStr = randomCode.toString();
        return randomCodeStr.substring(2,8);
    }

    public static void main(String[] args) {
        System.out.println(generateCode());
    }
}

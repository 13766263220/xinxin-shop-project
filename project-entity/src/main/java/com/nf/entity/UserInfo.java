package com.nf.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;//用户id
    private String phone;//用户电话（也是账号）
    private String passWord;//密码
    private Date registrationTime;//注册时间
    private String name;//用户名称
    private Integer sex;//性别 0->女 1->男
    private String address;//用户地址
    private Integer status;// 用户状态 ->0不可用 ->可用
}

package com.nf.dto;

import com.nf.entity.UserInfo;
import lombok.Data;

@Data
public class UserInfoDTO {
    private UserInfo userInfo;
    private String token;
    private String role; //角色 --> admin、user

}

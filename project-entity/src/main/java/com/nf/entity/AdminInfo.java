package com.nf.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminInfo {
    private Integer id;
    private String username;
    private String passWord;
}

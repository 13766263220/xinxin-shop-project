package com.nf.entity;

import lombok.Data;

/**
 * 角色表
 */
@Data
public class RoleInfo {
    private Integer id;
    private String name; //角色名称
    private String description; //角色描述
}

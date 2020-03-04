package com.nf.dao;

import com.nf.entity.RoleAdmin;

public interface RoleAdminDao {

    /**
     * 删除角色用户表数据
     * @param roleAdmin
     */
    void delRoleAdmin(RoleAdmin roleAdmin);

    /**
     * 添加角色用户表数据
     * @param roleAdmin
     */
    void addRoleAdmin(RoleAdmin roleAdmin);
}

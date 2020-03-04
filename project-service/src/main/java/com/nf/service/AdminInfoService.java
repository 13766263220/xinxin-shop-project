package com.nf.service;

import com.nf.entity.AdminInfo;

import java.util.List;

public interface AdminInfoService {
    AdminInfo getByUserName(String userName);

    List<AdminInfo> getAll(Integer pageNum,Integer pageSize);
    /**
     * 按照角色id查用户
     * @param roleId
     * @return
     */
    List<AdminInfo> getByRoleId(Integer pageNum,Integer pageSize,Integer roleId);

    void deleteAdminById(Integer id);
}

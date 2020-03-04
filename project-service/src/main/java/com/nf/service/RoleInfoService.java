package com.nf.service;

import com.nf.entity.RoleInfo;
import com.nf.entity.RoleName;

import java.util.List;

public interface RoleInfoService {
    /**
     * 查询所有角色
     * @param pageNum
     * @param pageSize
     * @param roleInfo
     * @return
     */
    List<RoleInfo> getAll(Integer pageNum,Integer pageSize,RoleInfo roleInfo);
    /**
     * 获得权限最大的角色名称
     * @param id
     * @return
     */
    String getMaxName(Integer id);
    /**
     * 添加角色
     * @param roleInfo
     */
    void addRoleInfo(RoleInfo roleInfo);

    /**
     * 按照id删除角色
     * @param id
     */
    boolean deleteById(Integer id);

    /**
     * 修改角色信息
     * @param roleInfo
     */
    void editRoleInfo(RoleInfo roleInfo);
}

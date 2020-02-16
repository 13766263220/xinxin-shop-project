package com.nf.dao;

import com.nf.entity.RoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleInfoDao {
    /**
     * 查询所有角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<RoleInfo> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 添加角色
     * @param roleInfo
     */
    void addRoleInfo(RoleInfo roleInfo);

    /**
     * 按照id删除角色
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改角色信息
     * @param roleInfo
     */
    void editRoleInfo(RoleInfo roleInfo);
}

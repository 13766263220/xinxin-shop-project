package com.nf.dao;

import com.nf.entity.RoleInfo;
import com.nf.entity.RoleName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleInfoDao {
    /**
     * 查询所有角色
     * @param pageNum
     * @param pageSize
     * @param roleInfo
     * @return
     */
    List<RoleInfo> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,@Param("roleInfo")RoleInfo roleInfo);

    /**
     * 按照角色id查询该角色内的用户数量
     * @param id
     * @return
     */
    Integer getUserCount(Integer id);

    /**
     * 获得用户所有角色名称
     * @param id
     * @return
     */
    List<RoleName> getRoleName(Integer id);

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

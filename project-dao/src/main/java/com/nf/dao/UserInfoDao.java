package com.nf.dao;

import com.nf.entity.AdminInfo;
import com.nf.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoDao {

    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @param userInfo
     * @return
     */
    List<UserInfo> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,@Param("userInfo") UserInfo userInfo);

    /**
     * 按照电话查询用户信息（用于用户登录）
     * @param phone
     * @return
     */
    UserInfo getByPhone(String phone);

    /**
     * 按照id删除用户
     * @param id
     */
    void deleteById(Integer id);

    /**
     *  修改用户信息
     * @param userInfo
     */
    void editUserInfo(UserInfo userInfo);

    /**
     * 添加用户信息
     * @param userInfo
     */
    void insertUserInfo(UserInfo userInfo);

}

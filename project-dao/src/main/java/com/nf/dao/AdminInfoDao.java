package com.nf.dao;

import com.nf.entity.AdminInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminInfoDao {
    AdminInfo getByUserName(String userName);

    List<AdminInfo> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    void deleteAdminById(Integer id);
}

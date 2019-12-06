package com.nf.service;

import com.nf.entity.AdminInfo;

import java.util.List;

public interface AdminInfoService {
    AdminInfo getByUserName(String userName);

    List<AdminInfo> getAll(Integer pageNum,Integer pageSize);

    void deleteAdminById(Integer id);
}

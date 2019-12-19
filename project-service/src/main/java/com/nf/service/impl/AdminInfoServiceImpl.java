package com.nf.service.impl;

import com.nf.dao.AdminInfoDao;
import com.nf.entity.AdminInfo;
import com.nf.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Autowired
    private AdminInfoDao adminInfoDao;

    @Override
    public AdminInfo getByUserName(String userName) {
        return adminInfoDao.getByUserName(userName);
    }

    @Override
    public List<AdminInfo> getAll(Integer pageNum, Integer pageSize) {
        return adminInfoDao.getAll(pageNum,pageSize);
    }

    @Override
    @Transactional
    public void deleteAdminById(Integer id) {//测试数据
        adminInfoDao.deleteAdminById(id);
        System.out.println(adminInfoDao.getByUserName("admin"));
    }
}

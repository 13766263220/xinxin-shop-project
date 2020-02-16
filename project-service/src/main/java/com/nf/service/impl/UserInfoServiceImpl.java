package com.nf.service.impl;

import com.nf.dao.UserInfoDao;
import com.nf.entity.UserInfo;
import com.nf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> getAll(Integer pageNum, Integer pageSize, UserInfo userInfo) {
        return userInfoDao.getAll(pageNum,pageSize,userInfo);
    }

    @Override
    public UserInfo getByPhone(String phone) {
        return userInfoDao.getByPhone(phone);
    }


    @Override
    public void deleteById(Integer id) {
        userInfoDao.deleteById(id);
    }

    @Override
    public void editUserInfo(UserInfo userInfo) {
        userInfoDao.editUserInfo(userInfo);
    }

    @Override
    public void insertUserInfo(UserInfo userInfo) {
        userInfoDao.insertUserInfo(userInfo);
    }
}

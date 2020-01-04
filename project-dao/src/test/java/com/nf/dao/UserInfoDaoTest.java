package com.nf.dao;

import com.nf.entity.UserInfo;
import config.DaoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class UserInfoDaoTest {
    @Autowired
    private UserInfoDao userInfoDao;
    @Test
    public void getAll() {
        UserInfo userInfo = new UserInfo();
        //userInfo.setName("正");
        userInfo.setAddress("江");
        List<UserInfo> list = userInfoDao.getAll(1,5,userInfo);
        for (UserInfo u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void deleteById() {
        userInfoDao.deleteById(5);
    }

    @Test
    public void editUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(6);
        userInfo.setPhone("sss");
        userInfo.setPassWord("sss");
        userInfo.setRegistrationTime(new Date());
        userInfo.setName("吴大帅");
        userInfo.setSex(0);
        userInfo.setAddress("江西");

        userInfoDao.editUserInfo(userInfo);
    }

    @Test
    public void insertUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone("sss");
        userInfo.setPassWord("sss");
        userInfo.setRegistrationTime(new Date());
        userInfo.setName("吴大帅");
        userInfo.setSex(0);
        userInfo.setAddress("江西");

        userInfoDao.insertUserInfo(userInfo);
    }
}
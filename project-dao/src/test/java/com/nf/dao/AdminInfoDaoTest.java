package com.nf.dao;

import com.nf.entity.AdminInfo;
import config.DaoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class AdminInfoDaoTest {
    @Autowired
    private AdminInfoDao adminInfoDao;

    @Test
    public void getByUserName() {
        AdminInfo adminInfo = adminInfoDao.getByUserName("admin");
        System.out.println(adminInfo);
    }

    @Test
    public void getAll() {
        List<AdminInfo> adminInfos = adminInfoDao.getAll(null, null);
        for (AdminInfo adminInfo : adminInfos) {
            System.out.println(adminInfo);
        }
    }


    @Test
    public void getByRoleId() {
//        List<AdminInfo> adminInfos = adminInfoDao.getByRoleId(2);
//        for (AdminInfo adminInfo : adminInfos) {
//            System.out.println(adminInfo);
//        }
    }
}
package com.nf.dao;

import com.nf.entity.RoleInfo;
import com.nf.entity.RoleName;
import config.DaoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class RoleInfoDaoTest {
    @Autowired
    private  RoleInfoDao roleInfoDao;
    @Test
    public void getAll() {
//        List<RoleInfo> result = roleInfoDao.getAll(1, 2);
//        for (RoleInfo roleInfo : result) {
//            System.out.println(roleInfo);
//        }
    }

    @Test
    public void getRoleName() {
        List<RoleName> roleNames = roleInfoDao.getRoleName(2);
        Integer count = 0;
        for (RoleName roleName : roleNames) {
            if(roleName.getCount()>count) {
                count = roleName.getCount();
            }
        }
        RoleName result = null;
        for (RoleName roleName : roleNames){
            if(roleName.getCount().equals(count)){
                result = roleName;
                break;
            }
        }
        System.out.println(result);
    }
}
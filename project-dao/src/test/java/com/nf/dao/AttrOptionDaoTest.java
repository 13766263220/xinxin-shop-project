package com.nf.dao;

import config.DaoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class AttrOptionDaoTest {
    @Autowired
    private AttrOptionDao attrOptionDao;
    @Test
    public void getByAttrId() {
        //System.out.println(attrOptionDao.getByAttrId(3));
    }
}
package com.nf.dao;

import com.nf.entity.OrderInfo;
import config.DaoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class OrderInfoDaoTest {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Test
    public void getAll() {
        List<OrderInfo> list = orderInfoDao.getAll(2,2);
        for (OrderInfo orderInfo : list) {
            System.out.println(orderInfo);
        }

    }
}
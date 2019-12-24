package com.nf.service.impl;

import com.nf.dao.OrderInfoDao;
import com.nf.entity.OrderInfo;
import com.nf.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoDao orderInfoDao;

    @Override
    public List<OrderInfo> getAll(Integer pageNum, Integer pageSize) {
        return orderInfoDao.getAll(pageNum,pageSize);
    }
}

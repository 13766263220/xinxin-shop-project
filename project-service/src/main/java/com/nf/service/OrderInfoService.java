package com.nf.service;

import com.nf.entity.OrderInfo;

import java.util.List;

public interface OrderInfoService {
    /**
     * 查询所有订单信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<OrderInfo> getAll(Integer pageNum,Integer pageSize);
}

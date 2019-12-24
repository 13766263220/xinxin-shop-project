package com.nf.dao;

import com.nf.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoDao {
    /**
     * 查询所有订单信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<OrderInfo> getAll(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
}

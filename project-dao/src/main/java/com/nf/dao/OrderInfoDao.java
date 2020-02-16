package com.nf.dao;

import com.nf.entity.OrderInfo;
import com.nf.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoDao {
    /**
     * 查询所有订单信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<OrderInfo> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);


    /**
     * 添加订单
     * @param orderInfo
     */
    void addOrder(OrderInfo orderInfo);

    /**
     *  按照用户账号(也是电话号码)查询用户所有订单
     * @param phone
     * @return
     */
    List<OrderInfo> getByPhone(String phone);


    /**
     * 按照用户账号与订单状态查询所有订单
     * @param orderInfo
     * @return
     */
    List<OrderInfo> getByPhoneAndStatus(OrderInfo orderInfo);

    /**
     * 修改订单信息
     * @param orderInfo
     */
    void editOrderInfo(OrderInfo orderInfo);

    /**
     * 按照id删除订单信息
     * @param id
     */
    void deleteById(Integer id);

}

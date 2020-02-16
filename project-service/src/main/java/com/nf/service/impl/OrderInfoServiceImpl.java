package com.nf.service.impl;

import com.nf.dao.CartItemDao;
import com.nf.dao.OrderInfoDao;
import com.nf.dao.ProductDao;
import com.nf.dao.ProductStockDao;
import com.nf.entity.CartItem;
import com.nf.entity.OrderInfo;
import com.nf.entity.Product;
import com.nf.entity.ProductStock;
import com.nf.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoDao orderInfoDao;
    @Autowired
    private CartItemDao cartItemDao;
    @Autowired
    private ProductStockDao productStockDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public List<OrderInfo> getAll(Integer pageNum, Integer pageSize) {
        return orderInfoDao.getAll(pageNum,pageSize);
    }

    /**
     * 添加订单
     * 并批量修改购物车项的订单id
     * 并修改库存的数量
     * @param orderInfo 订单信息
     * @param cartItems 购物车项信息
     */
    @Transactional
    @Override
    public void addOrder(OrderInfo orderInfo, CartItem[] cartItems) {
        //添加订单
        orderInfoDao.addOrder(orderInfo);
        for (CartItem cartItem : cartItems) {
            cartItem.setOrderId(orderInfo.getId());
            //修改库存表库存数量
            ProductStock productStock = productStockDao.getById(cartItem.getSkuId());
            Integer stockCount = productStock.getStock() - cartItem.getQuantity();
            if(stockCount < 0){
                throw new RuntimeException("库存数量不够");
            }
            productStock.setStock(stockCount);
            productStockDao.editStock(productStock);

        }
        //批量修改购物车项的订单id
        cartItemDao.batchEditOrderId(cartItems);
    }

    @Override
    public List<OrderInfo> getByPhone(String phone) {
        return orderInfoDao.getByPhone(phone);
    }

    @Override
    public List<OrderInfo> getByPhoneAndStatus(OrderInfo orderInfo) {
        return orderInfoDao.getByPhoneAndStatus(orderInfo);
    }

    @Override
    public void editOrderInfo(OrderInfo orderInfo) {
        orderInfoDao.editOrderInfo(orderInfo);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        //按照id删除商品项信息
        cartItemDao.deleteByOrderId(id);
        //删除按照id删除订单
        orderInfoDao.deleteById(id);
    }


}

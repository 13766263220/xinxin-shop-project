package com.nf.service;

import com.nf.entity.CartItem;

import java.util.List;

public interface CartItemService {
    /**
     * 按照用户id查询购物车项
     * @param userId
     * @return
     */
    List<CartItem> getByUserId(Integer userId);

    /**
     * 按照用户id和skuId查询购物车项
     * @param cartItem
     * @return
     */
    CartItem getByUserIdWithSkuId(CartItem cartItem);

    /**
     * 按照订单id查询购物车项信息
     * @param orderId
     * @return
     */
    List<CartItem> getByOrderId(Integer orderId);

    /**
     * 添加购物车项
     * @param cartItem
     */
    void addShoppingCart(CartItem cartItem);

    /**
     * 修改购物车项
     * @param cartItem
     */
    void editShoppingCart(CartItem cartItem);

    /**
     * 删除购物车项
     * @param id
     */
    void deleteShoppingCart(Integer id);
}

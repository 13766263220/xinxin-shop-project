package com.nf.service.impl;

import com.nf.dao.CartItemDao;
import com.nf.entity.CartItem;
import com.nf.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public List<CartItem> getByUserId(Integer userId) {
        return cartItemDao.getByUserId(userId);
    }

    @Override
    public CartItem getByUserIdWithSkuId(CartItem cartItem) {
        return cartItemDao.getByUserIdWithSkuId(cartItem);
    }

    @Override
    public List<CartItem> getByOrderId(Integer orderId) {
        return cartItemDao.getByOrderId(orderId);
    }

    @Override
    public void addShoppingCart(CartItem cartItem) {
        cartItemDao.addShoppingCart(cartItem);
    }

    @Override
    public void editShoppingCart(CartItem cartItem) {
        cartItemDao.editShoppingCart(cartItem);
    }

    @Override
    public void deleteShoppingCart(Integer id) {
        cartItemDao.deleteShoppingCart(id);
    }
}

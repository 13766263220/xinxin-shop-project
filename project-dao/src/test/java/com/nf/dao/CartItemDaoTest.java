package com.nf.dao;

import com.nf.entity.CartItem;
import config.DaoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class CartItemDaoTest {

    @Autowired
    private CartItemDao cartItemDao;

    @Test
    public void getByUserId() {
        List<CartItem> list = cartItemDao.getByUserId(10);
        for (CartItem cartItem : list) {
            System.out.println(cartItem);
        }

    }

    @Test
    public void addShoppingCart() {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(10);
        cartItem.setPrice(BigDecimal.valueOf(10));
        cartItem.setSkuId(36);
        cartItem.setUserId(1);

        cartItemDao.addShoppingCart(cartItem);
    }

    @Test
    public void editShoppingCart() {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(100);
        cartItem.setPrice(BigDecimal.valueOf(100));
        cartItem.setSkuId(360);
        cartItem.setUserId(10);
        cartItem.setId(2);
        cartItemDao.editShoppingCart(cartItem);
    }

    @Test
    public void deleteShoppingCart() {
        cartItemDao.deleteShoppingCart(2);
    }

    @Test
    public void batchEditOrderId() {
        CartItem cartItem1 = new CartItem();
        cartItem1.setId(3);
        cartItem1.setOrderId(0);

        CartItem cartItem2 = new CartItem();
        cartItem2.setId(2);
        cartItem2.setOrderId(0);

        CartItem [] cartItems = new CartItem[]{cartItem1,cartItem2};

        cartItemDao.batchEditOrderId(cartItems);
    }

    @Test
    public void getByOrderId() {
        List<CartItem> result = cartItemDao.getByOrderId(2);
        for (CartItem cartItem : result) {
            System.out.println(cartItem);
        }
    }
}
package com.nf.vo;

import com.nf.entity.CartItem;
import com.nf.entity.Product;
import com.nf.entity.ProductStock;
import lombok.Data;

@Data
public class CartItemVO {
    private CartItem cartItem; //购物车项信息
    private ProductStock productStock;//库存信息
    private Product product; // 商品信息
}

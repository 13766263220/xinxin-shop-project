package com.nf.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItem {
    private Integer id;
    private Integer quantity; //数量
    private BigDecimal price; //单价
    private Integer skuId; //库存id
    private Integer userId; //用户id
    private Integer orderId; //订单id
}

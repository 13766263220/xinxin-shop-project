package com.nf.entity;

import lombok.Data;

import java.math.BigDecimal;

//商品库存
@Data
public class ProductStock {
    private Integer id;
    private Integer productId;
    private BigDecimal price;
    private Integer stock;//库存
    private Integer lowStock;
    private String pic;//图片
    private Integer sale;//销量
    private String productSpecs;//规格 是个json数据

}

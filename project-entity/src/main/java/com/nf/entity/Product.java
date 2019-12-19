package com.nf.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Integer id;//商品id
    private String name;//商品名称
    private BigDecimal price;//商品价格
    private String pic;//商品图片
    private Integer brandId;//品牌id
    private ProductBrand productBrand;//品牌信息
    private Integer categoryId;//分类id
    private ProductCategory productCategory;//分类信息
    private Integer sale;//销量
    private Integer stock;//库存
    private Integer lowStock;//预警库存
    private String unit;//商品单位
    private String description;//商品描述
    private Integer publishStatus;//上架状态：0->下架；1->上架
    private Integer newStatus;//新品状态:0->不是新品；1->新品
    private Integer recommandStatus;//推荐状态；0->不推荐；1->推荐


}

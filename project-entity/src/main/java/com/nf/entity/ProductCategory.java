package com.nf.entity;

import lombok.Data;

//商品分类
@Data
public class ProductCategory {
    private Integer id;
    private Integer rank;//类型级别
    private Integer parentId;//上级分类
    private String name;//分类名称
    private Integer productCount;//商品数量
    private String productUnit;//商品单位
    private Integer showStatus;//是否显示
    private String icon;//图标
    private String description;//分类描述

}

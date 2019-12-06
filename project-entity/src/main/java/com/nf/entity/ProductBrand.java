package com.nf.entity;

import lombok.Data;

//商品品牌
@Data
public class ProductBrand {
    private Integer id;
    private String name;//品牌名称
    private Integer showStatus;//是否显示
    private Integer productCount;//商品数量
    private Integer productCommentCount;//评论数量
    private String logo;//品牌logo图片
    private String bigPic;//品牌专区大图
    private String brandStory;//品牌故事
}

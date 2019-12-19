package com.nf.service;

import com.nf.entity.ProductAttr;

import java.util.List;

public interface ProductAttrService {
    /**
     * 按照分类id查询所有的属性
     * @param categoryId
     * @return
     */
    List<ProductAttr> getAll(Integer categoryId);

    /**
     * 添加商品属性
     * @param productAttr
     */
    void insertAttr(ProductAttr productAttr);

    /**
     * 修改属性名称
     * @param productAttr
     */
    void editAttr(ProductAttr productAttr);

    /**
     * 按照属性id 删除属性信息
     * @param attrId
     */
    Boolean deleteAttr(Integer attrId);
}

package com.nf.dao;

import com.nf.entity.ProductAttr;
import com.nf.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductAttrDao {

    /**
     * 按照分类id查询所有的属性
     *
     * @param categoryId
     * @return
     */
    List<ProductAttr> getAll(@Param("categoryId") Integer categoryId);

    Integer getAttrCount(Integer categoryId);

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
    void deleteAttr(Integer attrId);
}

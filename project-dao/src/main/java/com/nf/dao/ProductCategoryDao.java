package com.nf.dao;

import com.nf.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 查看一级商品类型
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProductCategory> getStairAll(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
}

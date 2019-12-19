package com.nf.dao;

import com.nf.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有商品信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Product> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询筛选商品信息
     *
     * @return
     */
    List<Product> getScreenAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("product") Product product);


     Product getAttributeList(Integer id);

    /**
     * 添加商品信息
     * @param product
     */
     void insertProduct(Product product);
}

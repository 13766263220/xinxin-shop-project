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

    /**
     * 按照id查询商品信息
     * @param id
     * @return
     */
    Product getById(Integer id);

    /**
     * 查询所有商品信息（不分页）
     * @return
     */
    List<Product> getAll();

    /**
     * 添加商品信息
     * @param product
     */
     void insertProduct(Product product);

    /**
     * 修改商品信息
     * @param product
     */
     void editProduct(Product product);
}

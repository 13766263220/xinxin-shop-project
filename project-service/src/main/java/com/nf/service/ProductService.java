package com.nf.service;

import com.nf.entity.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有商品信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Product> getAll(Integer pageNum,Integer pageSize);

    /**
     * 查询所有商品信息（不分页）
     * @return
     */
    List<Product> getAll();

    /**
     * 查询筛选商品信息
     * @return
     */
    List<Product> getScreenAll(Integer pageNum,Integer pageSize,Product product);

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

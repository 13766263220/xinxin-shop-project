package com.nf.service;

import com.nf.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getStairAll(Integer pageNum,Integer pageSize);

    /**
     * 查询所有一级二级分类信息
     * @return
     */
    List<ProductCategory> getAll();

    /**
     * 删除类型
     * @param id
     */
    Boolean deleteById(Integer id);

    /**
     * 删除二级类型
     * @param id
     */
    Boolean deleteSonById(Integer id);


    /**
     * 修改类型
     * @param productCategory
     */
    void editCategory(ProductCategory productCategory);

    /**
     * 按照类型id查询
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    List<ProductCategory> getByParentId(Integer pageNum,Integer pageSize,Integer categoryId);

    List<ProductCategory> getByParentId(Integer parentId);

    /**
     * 添加商品类型
     * @param productCategory
     */
    void insertCategory(ProductCategory productCategory);
}

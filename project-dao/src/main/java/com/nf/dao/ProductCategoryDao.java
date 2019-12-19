package com.nf.dao;

import com.nf.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 查看一级商品类型
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProductCategory> getStairAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询所有一级二级分类信息
     * @return
     */
    List<ProductCategory> getAll();

    /**
     * 删除类型
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 查询二级的数量
     * @param parentId
     * @return
     */
    Integer getCountByParentId(Integer parentId);

    /**
     * 修改类型
     * @param productCategory
     */
    void editCategory(ProductCategory productCategory);

    /**
     * 按照类型上级id查询上级类型
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    List<ProductCategory> getByParentId(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,@Param("categoryId") Integer categoryId);

    /**
     * 按照类型上级id查询上级类型
     * @param parentId
     * @return
     */
    List<ProductCategory> getByParentId(Integer parentId);

    /**
     * 添加商品类型
     * @param productCategory
     */
    void insertCategory(ProductCategory productCategory);
}

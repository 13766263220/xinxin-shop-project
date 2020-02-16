package com.nf.dao;

import com.nf.entity.CartItem;
import com.nf.entity.ProductStock;

import java.util.List;

public interface ProductStockDao {
    List<ProductStock> getByProductId(Integer productId);

    /**
     * 添加规格
     * @param productStock
     */
    void insertStock(ProductStock productStock);

    /**
     * 按照属性查询数量
     * @param specs
     * @return
     */
    Integer getCountBySpecs(String specs);

    /**
     * 删除SKU数据
     * @param stockId
     */
    void deleteStockById(Integer stockId);

    /**
     * 编辑SKU库存
     * @param productStock
     */
    void editStock(ProductStock productStock);

    /**
     * 按照规格查询sku
     * @param specs
     * @return
     */
    ProductStock getStockBySpecs(String specs);

    /**
     * 按照id查询sku
     * @param id
     * @return
     */
    ProductStock getById(Integer id);

}

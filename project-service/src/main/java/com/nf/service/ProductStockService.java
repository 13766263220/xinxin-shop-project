package com.nf.service;

import com.nf.entity.ProductStock;

import java.util.List;

public interface ProductStockService {
    List<ProductStock> getByProductId(Integer productId);

    /**
     * 按照id查询sku
     * @param id
     * @return
     */
    ProductStock getById(Integer id);

    /**
     * 添加规格
     * @param productStock
     */
    Boolean insertStock(ProductStock productStock);

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
}

package com.nf.service.impl;

import com.nf.dao.ProductStockDao;
import com.nf.entity.ProductStock;
import com.nf.service.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductStockServiceImpl implements ProductStockService {
    @Autowired
    private ProductStockDao productStockDao;
    @Override
    public List<ProductStock> getByProductId(Integer productId) {
        return productStockDao.getByProductId(productId);
    }

    @Override
    @Transactional
    public Boolean insertStock(ProductStock productStock) {
        Integer count = productStockDao.getCountBySpecs(productStock.getProductSpecs());
        if (count.equals(0)){
            productStockDao.insertStock(productStock);
            return true;
        }
        return false;
    }

    @Override
    public void deleteStockById(Integer stockId) {
        productStockDao.deleteStockById(stockId);
    }

    @Override
    public void editStock(ProductStock productStock) {
        productStockDao.editStock(productStock);
    }

}

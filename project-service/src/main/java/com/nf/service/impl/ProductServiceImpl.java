package com.nf.service.impl;

import com.nf.dao.ProductDao;
import com.nf.entity.Product;
import com.nf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getAll(Integer pageNum, Integer pageSize) {
        return productDao.getAll(pageNum,pageSize);
    }

    @Override
    public List<Product> getScreenAll(Integer pageNum, Integer pageSize, Product product) {
        return productDao.getScreenAll(pageNum,pageSize,product);
    }

    @Override
    public void insertProduct(Product product) {
        productDao.insertProduct(product);
    }
}

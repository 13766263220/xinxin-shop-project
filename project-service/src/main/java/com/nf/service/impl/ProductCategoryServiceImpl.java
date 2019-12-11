package com.nf.service.impl;

import com.nf.dao.ProductCategoryDao;
import com.nf.entity.ProductCategory;
import com.nf.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getStairAll(Integer pageNum, Integer pageSize) {
        return productCategoryDao.getStairAll(pageNum,pageSize);
    }
}

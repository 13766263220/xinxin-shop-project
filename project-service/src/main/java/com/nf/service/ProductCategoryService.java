package com.nf.service;

import com.nf.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getStairAll(Integer pageNum,Integer pageSize);
}

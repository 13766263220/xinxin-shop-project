package com.nf.service;

import com.nf.entity.ProductBrand;

import java.util.List;

public interface ProductBrandService {
    List<ProductBrand> getAll(Integer pageNum,Integer pageSize);
    List<ProductBrand> getByName(Integer pageNum,Integer pageSize,String name);
}

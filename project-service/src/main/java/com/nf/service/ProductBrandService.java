package com.nf.service;

import com.nf.entity.ProductBrand;

import java.util.List;

public interface ProductBrandService {
    List<ProductBrand> getAll(Integer pageNum,Integer pageSize);
    List<ProductBrand> getAll();
    List<ProductBrand> getByName(Integer pageNum,Integer pageSize,String name);
    void deleteById(Integer brandId);
    void insertBrand(ProductBrand productBrand);
    void editBrand(ProductBrand productBrand);
    void batchDeleteById(Integer[] ids);
    void batchUpdateStatusById(ProductBrand[] productBrands);
}

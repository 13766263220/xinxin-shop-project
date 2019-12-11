package com.nf.service.impl;

import com.nf.dao.ProductBrandDao;
import com.nf.entity.ProductBrand;
import com.nf.service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBrandServiceImpl implements ProductBrandService {
    @Autowired
    private ProductBrandDao productBrandDao;

    @Override
    public List<ProductBrand> getAll(Integer pageNum, Integer pageSize) {
        return productBrandDao.getAll(pageNum,pageSize);
    }

    @Override
    public List<ProductBrand> getByName(Integer pageNum, Integer pageSize, String name) {
        return productBrandDao.getByName(pageNum,pageSize,name);
    }

    @Override
    public void deleteById(Integer brandId) {
        productBrandDao.deleteById(brandId);
        //这里需要一个事务处理
    }

    @Override
    public void insertBrand(ProductBrand productBrand) {
        productBrandDao.insertBrand(productBrand);
    }

    @Override
    public void editBrand(ProductBrand productBrand) {
        productBrandDao.editBrand(productBrand);
    }

    @Override
    public void batchDeleteById(Integer[] ids) {
        productBrandDao.batchDeleteById(ids);
    }

    @Override
    public void batchUpdateStatusById(ProductBrand[] productBrands) {
        productBrandDao.batchUpdateStatusById(productBrands);
    }


}

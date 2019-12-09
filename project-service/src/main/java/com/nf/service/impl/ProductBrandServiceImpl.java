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


}

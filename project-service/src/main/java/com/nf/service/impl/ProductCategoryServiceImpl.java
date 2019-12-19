package com.nf.service.impl;

import com.nf.dao.ProductAttrDao;
import com.nf.dao.ProductCategoryDao;
import com.nf.entity.ProductCategory;
import com.nf.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Autowired
    private ProductAttrDao productAttrDao;

    @Override
    public List<ProductCategory> getStairAll(Integer pageNum, Integer pageSize) {
        return productCategoryDao.getStairAll(pageNum,pageSize);
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryDao.getAll();
    }

    @Override
    @Transactional
    public Boolean deleteById(Integer id) {
        //获得二级的数量
        Integer count = productCategoryDao.getCountByParentId(id);
        if(count.equals(0)){
            //删除一级类型
            productCategoryDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteSonById(Integer id) {
        //获得二级的属性的数量
        Integer count = productAttrDao.getAttrCount(id);
        if(count.equals(0)){
            //删除二级类型
            productCategoryDao.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public void editCategory(ProductCategory productCategory) {
        productCategoryDao.editCategory(productCategory);
    }

    @Override
    public List<ProductCategory> getByParentId(Integer pageNum, Integer pageSize, Integer categoryId) {
        return productCategoryDao.getByParentId(pageNum, pageSize, categoryId);
    }

    @Override
    public List<ProductCategory> getByParentId(Integer parentId) {
        return productCategoryDao.getByParentId(parentId);
    }

    @Override
    public void insertCategory(ProductCategory productCategory) {
        productCategoryDao.insertCategory(productCategory);
    }
}

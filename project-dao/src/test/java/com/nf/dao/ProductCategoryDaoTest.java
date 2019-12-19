package com.nf.dao;

import com.nf.entity.ProductCategory;
import config.DaoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao categoryDao;

    @Test
    public void getStairAll() {
        List<ProductCategory> list = categoryDao.getStairAll(2, 2);
        for (ProductCategory productCategory : list) {
            System.out.println(productCategory);
        }
    }

    @Test
    public void deleteById() {
        categoryDao.deleteById(14);
    }

    @Test
    public void editCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(14);
        productCategory.setName("汽车用品2");
        categoryDao.editCategory(productCategory);
    }

    @Test
    public void getByParentId() {
        List<ProductCategory> list = categoryDao.getByParentId(2, 5, 1);
        for (ProductCategory productCategory : list) {
            System.out.println(productCategory);
        }
    }


    @Test
    public void testGetByParentId() {
        List<ProductCategory> list = categoryDao.getByParentId(0);
        for (ProductCategory productCategory : list) {
            System.out.println(productCategory);
        }
    }

    @Test
    public void getAll() {
        List<ProductCategory> list = categoryDao.getAll();
        for (ProductCategory productCategory : list) {
            System.out.println(productCategory);
        }
    }
}
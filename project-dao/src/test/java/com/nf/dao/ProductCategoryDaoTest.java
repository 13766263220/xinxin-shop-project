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
}
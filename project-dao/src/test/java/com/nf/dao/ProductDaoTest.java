package com.nf.dao;

import com.nf.entity.Product;
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
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void getAll() {
        List<Product> list = productDao.getAll(1,10);
        for (Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    public void getScreenAll() {
        Product product = new Product();
        product.setName("为");
        product.setCategoryId(12);
        product.setBrandId(3);
        product.setPublishStatus(0);

        List<Product> list = productDao.getScreenAll(1,5,product);
        for (Product p : list) {
            System.out.println(p);
        }
    }

    @Test
    public void getAttributeList() {
        Product product = productDao.getAttributeList(1);
        System.out.println(product);
    }

    @Test
    public void insertProduct() {
        Product product = new Product();
        product.setName("休闲裤子");
        productDao.insertProduct(product);
    }
}
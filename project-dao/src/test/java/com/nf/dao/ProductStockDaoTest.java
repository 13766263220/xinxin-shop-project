package com.nf.dao;

import com.nf.entity.ProductStock;
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
public class ProductStockDaoTest {
    @Autowired
    private ProductStockDao productStockDao;
    @Test
    public void getByProductId() {
        List<ProductStock> list = productStockDao.getByProductId(1);
        for (ProductStock stock : list) {
            System.out.println(stock);
        }
    }

    @Test
    public void deleteStockById() {
        productStockDao.deleteStockById(1);
    }

    @Test
    public void editStock() {
        ProductStock productStock = new ProductStock();
    }
}
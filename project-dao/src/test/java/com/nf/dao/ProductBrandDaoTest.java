package com.nf.dao;

import com.nf.entity.Product;
import com.nf.entity.ProductBrand;
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
public class ProductBrandDaoTest {

    @Autowired
    ProductBrandDao productBrandDao;

    @Test
    public void getAll() {
        List<ProductBrand> list = productBrandDao.getAll(1,10);
        for (ProductBrand productBrand : list) {
            System.out.println(productBrand);
        }
    }


    @Test
    public void getByName() {
        List<ProductBrand> list=productBrandDao.getByName(1,1,"米");
        for (ProductBrand brand : list) {
            System.out.println(brand);
        }
    }

    @Test
    public void insertBrand() {
        ProductBrand productBrand = new ProductBrand();
        productBrand.setName("王老吉");
        productBrandDao.insertBrand(productBrand);
    }

    @Test
    public void batchDeleteById() {
        Integer [] ids = new Integer[]{7,8};
        productBrandDao.batchDeleteById(ids);
    }

    @Test
    public void batchUpdateStatusById() {
        ProductBrand productBrand1 = new ProductBrand();
        productBrand1.setId(6);
        productBrand1.setShowStatus(0);

        ProductBrand productBrand2 = new ProductBrand();
        productBrand2.setId(10);
        productBrand2.setShowStatus(1);

        ProductBrand[] brands = new ProductBrand[2];
        brands[0]= productBrand1;
        brands[1] = productBrand2;

        productBrandDao.batchUpdateStatusById(brands);
    }
}
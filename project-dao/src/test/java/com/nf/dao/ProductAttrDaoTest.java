package com.nf.dao;

import com.nf.entity.ProductAttr;
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
public class ProductAttrDaoTest {

    @Autowired
    private ProductAttrDao productAttrDao;
    @Test
    public void getAll() {
        List<ProductAttr> attrs = productAttrDao.getAll(13);
        for (ProductAttr attr : attrs) {
            System.out.println(attr);
        }
    }


}
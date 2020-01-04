package com.nf.service.impl;

import com.nf.dao.AttrOptionDao;
import com.nf.dao.ProductAttrDao;
import com.nf.entity.AttrOption;
import com.nf.entity.ProductAttr;
import com.nf.service.ProductAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductAttrServiceImpl implements ProductAttrService {

    @Autowired
    private ProductAttrDao productAttrDao;
    @Autowired
    private AttrOptionDao attrOptionDao;

    @Override
    public List<ProductAttr> getAll(Integer categoryId) {
        List<ProductAttr> productAttrs = productAttrDao.getAll(categoryId);
        for (ProductAttr productAttr : productAttrs) {
            //按照id排序
            Collections.sort(productAttr.getAttrOptions());
        }
        return productAttrs;
    }


    @Override
    public void insertAttr(ProductAttr productAttr) {
        productAttrDao.insertAttr(productAttr);
    }

    @Override
    public void editAttr(ProductAttr productAttr) {
        productAttrDao.editAttr(productAttr);
    }

    @Override
    @Transactional
    public Boolean deleteAttr(Integer attrId) {
        //删除之前断一下是否有属性选项 (子数据)
        if(attrOptionDao.getAttrOptionCount(attrId).equals(0)){
            productAttrDao.deleteAttr(attrId);
            return true;
        }
        return false;
    }
}

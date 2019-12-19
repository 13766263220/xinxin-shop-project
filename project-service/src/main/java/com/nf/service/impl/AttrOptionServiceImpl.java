package com.nf.service.impl;

import com.nf.dao.AttrOptionDao;
import com.nf.entity.AttrOption;
import com.nf.service.AttrOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttrOptionServiceImpl implements AttrOptionService {
    @Autowired
    private AttrOptionDao attrOptionDao;

    @Override
    public void insertAttrOption(AttrOption attrOption) {
        attrOptionDao.insertAttrOption(attrOption);
    }

    @Override
    public void deleteAttrOption(Integer optionId) {
        attrOptionDao.deleteAttrOption(optionId);
    }
}

package com.nf.service.impl;

import com.nf.dao.RoleInfoDao;
import com.nf.entity.RoleInfo;
import com.nf.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoDao roleInfoDao;

    @Override
    public List<RoleInfo> getAll(Integer pageNum, Integer pageSize) {
        return roleInfoDao.getAll(pageNum,pageSize);
    }
}

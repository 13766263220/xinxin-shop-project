package com.nf.service.impl;

import com.nf.dao.RoleNodeDao;
import com.nf.entity.RoleNode;
import com.nf.service.RoleNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleNodeServiceImpl implements RoleNodeService {
    @Autowired
    private RoleNodeDao roleNodeDao;

    @Override
    public void batchAddInfo(List<RoleNode> roleNodes) {
        roleNodeDao.batchAddInfo(roleNodes);
    }

    @Override
    public void batchDelInfo(List<RoleNode> roleNodes) {
        roleNodeDao.batchDelInfo(roleNodes);
    }

    @Override
    @Transactional
    public void authorization(List<RoleNode> roleNodes) {
        roleNodeDao.batchDelInfo(roleNodes);
        roleNodeDao.batchAddInfo(roleNodes);
    }
}

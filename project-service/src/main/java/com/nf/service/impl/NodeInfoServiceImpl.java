package com.nf.service.impl;

import com.nf.dao.NodeInfoDao;
import com.nf.entity.NodeInfo;
import com.nf.service.NodeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeInfoServiceImpl implements NodeInfoService {
    @Autowired
    private NodeInfoDao nodeInfoDao;
    @Override
    public List<NodeInfo> getNodeByAdminId(Integer adminId) {
        return nodeInfoDao.getNodeByAdminId(adminId);
    }
}

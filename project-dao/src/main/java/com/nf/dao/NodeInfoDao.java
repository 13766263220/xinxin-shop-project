package com.nf.dao;

import com.nf.entity.NodeInfo;

import java.util.List;

public interface NodeInfoDao {
    List<NodeInfo> getNodeByAdminId(Integer adminId);
}

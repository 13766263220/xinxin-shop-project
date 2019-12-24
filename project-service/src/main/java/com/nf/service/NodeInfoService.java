package com.nf.service;

import com.nf.entity.NodeInfo;

import java.util.List;

public interface NodeInfoService {
    List<NodeInfo> getNodeByAdminId(Integer adminId);
}

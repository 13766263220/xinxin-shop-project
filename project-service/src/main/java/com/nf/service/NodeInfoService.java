package com.nf.service;

import com.nf.entity.NodeInfo;

import java.util.List;

public interface NodeInfoService {
    List<NodeInfo> getNodeByAdminId(Integer adminId);
    /**
     * 查询所有路由信息
     * @return
     */
    List<NodeInfo>  getAll();
    /**
     * 按照角色id查询所有节点
     * @return
     */
    List<NodeInfo> getByRoleId(Integer id);

}

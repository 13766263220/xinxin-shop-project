package com.nf.dao;

import com.nf.entity.NodeInfo;

import java.util.List;

public interface NodeInfoDao {
    /**
     * 查询某个用户得所有路由
     * @param adminId
     * @return
     */
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

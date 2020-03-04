package com.nf.dao;

import com.nf.entity.RoleNode;

import java.util.List;

public interface RoleNodeDao {

    /**
     * 批量添加
     * @param roleNodes
     */
    void batchAddInfo(List<RoleNode> roleNodes);

    /**
     * 批量删除
     * @param roleNodes
     */
    void batchDelInfo(List<RoleNode> roleNodes);
}

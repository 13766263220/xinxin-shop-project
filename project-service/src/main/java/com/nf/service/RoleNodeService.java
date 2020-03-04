package com.nf.service;

import com.nf.entity.RoleNode;

import java.util.List;

public interface RoleNodeService {
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

    /**
     * 授权
     * @param roleNodes
     */
    void authorization(List<RoleNode> roleNodes);
}

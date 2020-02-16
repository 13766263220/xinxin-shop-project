package com.nf.service;

import com.nf.entity.RoleInfo;

import java.util.List;

public interface RoleInfoService {
    /**
     * 查询所有角色
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<RoleInfo> getAll(Integer pageNum,Integer pageSize);
}

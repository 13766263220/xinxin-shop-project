package com.nf.service.impl;

import com.nf.dao.RoleAdminDao;
import com.nf.entity.RoleAdmin;
import com.nf.service.RoleAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleAdminServiceImpl implements RoleAdminService {
    @Autowired
    private RoleAdminDao roleAdminDao;

    @Override
    public void delRoleAdmin(RoleAdmin roleAdmin) {
        roleAdminDao.delRoleAdmin(roleAdmin);
    }

    @Override
    public void addRoleAdmin(RoleAdmin roleAdmin) {
        roleAdminDao.addRoleAdmin(roleAdmin);
    }
}

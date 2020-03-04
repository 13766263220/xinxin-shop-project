package com.nf.service.impl;

import com.nf.dao.RoleInfoDao;
import com.nf.entity.RoleInfo;
import com.nf.entity.RoleName;
import com.nf.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoDao roleInfoDao;


    @Override
    public List<RoleInfo> getAll(Integer pageNum, Integer pageSize, RoleInfo roleInfo) {
        return roleInfoDao.getAll(pageNum,pageSize,roleInfo);
    }

    /**
     * @param id 用户id
     * @return
     */
    @Override
    public String getMaxName(Integer id) {
        List<RoleName> roleNames = roleInfoDao.getRoleName(id);
        Integer count = 0;
        for (RoleName roleName : roleNames) {
            if(roleName.getCount()>count) {
                count = roleName.getCount();
            }
        }
        RoleName result = null;
        for (RoleName roleName : roleNames){
            if(roleName.getCount().equals(count)){
                result = roleName;
                break;
            }
        }
        return result.getRoleName();
    }

    @Override
    public void addRoleInfo(RoleInfo roleInfo) {
        roleInfoDao.addRoleInfo(roleInfo);
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        Integer userCount = roleInfoDao.getUserCount(id);
        if(userCount!=null && userCount == 0){
            roleInfoDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void editRoleInfo(RoleInfo roleInfo) {
        roleInfoDao.editRoleInfo(roleInfo);
    }
}

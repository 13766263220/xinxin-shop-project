package com.nf.vo;

import com.nf.entity.AdminInfo;
import com.nf.entity.NodeInfo;
import com.nf.entity.RoleInfo;
import lombok.Data;

import java.util.List;

//用户，角色，节点
@Data
public class AdminRoleNodeVO {
    private AdminInfo adminInfo;
    private List<RoleInfo> roles;
    private List<NodeInfo> routes;
    private List<NodeInfo> menus;

}

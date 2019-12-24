package com.nf.entity;

import lombok.Data;

import java.util.List;

/**
 * 节点表
 */
@Data
public class NodeInfo {
    private Integer id;
    private String name;//节点名称
    private String route;//节点路由(前端路由地址)
    private String url;//
    private Integer pid;//父级节点id

    private List<NodeInfo> child;
}

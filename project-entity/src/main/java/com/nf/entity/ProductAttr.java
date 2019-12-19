package com.nf.entity;

import lombok.Data;

import java.util.List;

@Data
public class ProductAttr {
    private Integer id;
    private String name;
    private String categoryId;
    private List<AttrOption> attrOptions;

}

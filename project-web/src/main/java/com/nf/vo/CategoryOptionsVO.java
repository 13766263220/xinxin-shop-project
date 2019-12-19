package com.nf.vo;

import com.nf.entity.ProductCategory;
import lombok.Data;

import java.awt.*;
import java.util.List;

/**
 * 类型选项框
 */
@Data
public class CategoryOptionsVO {
    private Integer value;
    private String label;
    private List<CategoryOptionsVO> children;
}

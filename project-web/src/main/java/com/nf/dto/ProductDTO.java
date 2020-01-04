package com.nf.dto;

import com.nf.entity.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer pageNum;
    private Integer pageSize;
    private Product product;

}

package com.nf.tdo;

import com.nf.entity.Product;
import lombok.Data;

@Data
public class ProductTDO {
    private Integer pageNum;
    private Integer pageSize;
    private Product product;

}

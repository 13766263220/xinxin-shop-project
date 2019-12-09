package com.nf.dao;

import com.nf.entity.ProductBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductBrandDao {

    List<ProductBrand> getAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<ProductBrand> getByName(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,@Param("name") String name);
}

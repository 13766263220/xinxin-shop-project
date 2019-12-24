package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.entity.ProductBrand;
import com.nf.service.ProductBrandService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/brand")
public class ProductBrandController{
    @Autowired
    private ProductBrandService productBrandService;

    @PostMapping("/list")
    public ResponseVO list(Integer pageNum,Integer pageSize) {
        PageInfo result = new PageInfo(productBrandService.getAll(pageNum,pageSize));
        return ResponseVO.builder().code("200").data(result).build();
    }

    @GetMapping("/getAll")
    public ResponseVO getAll() {
        List<ProductBrand> result = productBrandService.getAll();
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/querybyname")
    public ResponseVO queryByName(Integer pageNum,Integer pageSize,String name) {
         PageInfo result = new PageInfo(productBrandService.getByName(pageNum,pageSize,name));
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/deletebyid")
    public ResponseVO deleteById(Integer brandId){
        productBrandService.deleteById(brandId);
        return ResponseVO.builder().code("200").build();
    }

    @PostMapping("/insert")
    public ResponseVO insertBrand(@RequestBody ProductBrand productBrand){
        productBrandService.insertBrand(productBrand);
        return ResponseVO.builder().code("200").build();
    }

    @PostMapping("/edit")
    public ResponseVO editBrand(@RequestBody ProductBrand productBrand){
        productBrandService.editBrand(productBrand);
        return ResponseVO.builder().code("200").build();
    }

    @PostMapping("/batchDeleteById")
    public ResponseVO batchDelete(@RequestBody Integer[] ids){
        productBrandService.batchDeleteById(ids);
        return ResponseVO.builder().code("200").build();
    }

    @PostMapping("/batchUpdateStatus")
    public ResponseVO batchUpdateStatus(@RequestBody ProductBrand[] productBrands){
        productBrandService.batchUpdateStatusById(productBrands);
        return ResponseVO.builder().code("200").build();
    }
}

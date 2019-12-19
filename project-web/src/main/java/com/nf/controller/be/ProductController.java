package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.dao.ProductDao;
import com.nf.entity.Product;
import com.nf.service.ProductService;
import com.nf.tdo.ProductTDO;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//设置跨域
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("list")
    public ResponseVO list(Integer pageNum,Integer pageSize){
        PageInfo pageInfo = new PageInfo(productService.getAll(pageNum,pageSize));
        return ResponseVO.builder().code("200").data(pageInfo).build();
    }

    @PostMapping("getScreenAll")
    public ResponseVO getScreenAll(@RequestBody ProductTDO productTDO){
        PageInfo pageInfo = new PageInfo(productService.getScreenAll(
                productTDO.getPageNum(),
                productTDO.getPageSize(),
                productTDO.getProduct())
        );
        return ResponseVO.builder().code("200").data(pageInfo).build();
    }

    @PostMapping("/insertProduct")
    public ResponseVO insertProduct(@RequestBody Product product){
        productService.insertProduct(product);
        return ResponseVO.builder().code("200").build();
    }


}

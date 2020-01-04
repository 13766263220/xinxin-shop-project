package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.entity.Product;
import com.nf.service.ProductService;
import com.nf.dto.ProductDTO;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("list")
    public ResponseVO list(){
        List<Product> result = productService.getAll();
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("getScreenAll")
    public ResponseVO getScreenAll(@RequestBody ProductDTO productTDO){
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

    @PostMapping("/editProduct")
    public ResponseVO editProduct(@RequestBody Product product){
        productService.editProduct(product);
        return ResponseVO.builder().code("200").build();
    }


}

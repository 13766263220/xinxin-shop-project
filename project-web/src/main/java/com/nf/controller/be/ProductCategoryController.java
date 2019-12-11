package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.service.ProductCategoryService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//设置跨域
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/category")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/list")
    public ResponseVO list(Integer pageNum, Integer pageSize){
        PageInfo pageInfo = new PageInfo(productCategoryService.getStairAll(pageNum,pageSize));
        return ResponseVO.builder().code("200").data(pageInfo).build();
    }
}

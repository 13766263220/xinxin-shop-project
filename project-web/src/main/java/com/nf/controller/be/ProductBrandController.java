package com.nf.controller.be;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.nf.service.ProductBrandService;
import com.nf.vo.PageVO;
import com.nf.vo.ProductBrandVO;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//设置跨域
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/brand")
public class ProductBrandController{
    @Autowired
    private ProductBrandService productBrandService;

    @PostMapping("/list")
    public ResponseVO list(@RequestBody PageVO pageVO) {
        PageInfo result = new PageInfo(productBrandService.getAll(pageVO.getPageNum(),pageVO.getPageSize()));
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/querybyname")
    public ResponseVO queryByName(@RequestBody ProductBrandVO productBrandVO) {
         PageInfo result = new PageInfo(productBrandService.getByName(
                productBrandVO.getPageVO().getPageNum(),
                productBrandVO.getPageVO().getPageSize(),
                productBrandVO.getProductBrand().getName()));
        for (Object o : result.getList()) {
            System.out.println(o);
        }

        return ResponseVO.builder().code("200").data(result).build();
    }
}

package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.entity.ProductAttr;
import com.nf.service.ProductAttrService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productAttr")
public class ProductAttrController {
    @Autowired
    private ProductAttrService productAttrService;

    @PostMapping("/list")
    public ResponseVO list(Integer categoryId) {
        List<ProductAttr> result = productAttrService.getAll(categoryId);
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/insertAttr")
    public ResponseVO insertAttr(@RequestBody ProductAttr productAttr) {
        productAttrService.insertAttr(productAttr);
        return ResponseVO.builder().code("200").build();
    }

    @PostMapping("/editAttr")
    public ResponseVO editAttr(@RequestBody ProductAttr productAttr) {
        productAttrService.editAttr(productAttr);
        return ResponseVO.builder().code("200").build();
    }

    @PostMapping("/deleteAttr")
    public ResponseVO deleteAttr(Integer attrId) {
        Boolean result = productAttrService.deleteAttr(attrId);
        return ResponseVO.builder().code("200").data(result).build();
    }
}

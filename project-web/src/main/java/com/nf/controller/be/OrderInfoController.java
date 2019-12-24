package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.service.OrderInfoService;
import com.nf.service.ProductBrandService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    @PostMapping("/list")
    public ResponseVO list(Integer pageNum, Integer pageSize) {
        PageInfo result = new PageInfo(orderInfoService.getAll(pageNum,pageSize));
        return ResponseVO.builder().code("200").data(result).build();
    }
}

package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.entity.ProductStock;
import com.nf.service.ProductStockService;
import com.nf.utils.JwtUtil;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class ProductStockController {
    @Autowired
    private ProductStockService productStockService;

    @PostMapping("/getByProductId")
    public ResponseVO getByProductId(Integer productId){
        List<ProductStock> result = productStockService.getByProductId(productId);
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/insertStock")
    public ResponseVO insertStock(@RequestBody ProductStock productStock) {
        Boolean result = productStockService.insertStock(productStock);
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/deleteStockById")
    public ResponseVO deleteStockById(Integer stockId) {
        productStockService.deleteStockById(stockId);
        return ResponseVO.builder().code("200").build();
    }

    @PostMapping("/editStock")
    public ResponseVO editStock(@RequestBody ProductStock productStock) {
        productStockService.editStock(productStock);
        return ResponseVO.builder().code("200").build();
    }

    /**
     * 按照规格查询sku
     * @param specs
     * @return
     */
    @GetMapping("/getStockBySpecs")
    public ResponseVO getStockBySpecs(String specs) {
        ProductStock productStock = productStockService.getStockBySpecs(specs);
        return ResponseVO.builder().code("200").data(productStock).build();
    }
}

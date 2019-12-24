package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.entity.ProductCategory;
import com.nf.service.ProductCategoryService;
import com.nf.vo.CategoryOptionsVO;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/getAll")
    public ResponseVO getAll(){
        List<ProductCategory> result = productCategoryService.getAll();
        List<CategoryOptionsVO> optionsVOS = new ArrayList<>();
        for (ProductCategory productCategory : result) {
            CategoryOptionsVO optionsVO = new CategoryOptionsVO();
            optionsVO.setValue(productCategory.getId());
            optionsVO.setLabel(productCategory.getName());
            List<CategoryOptionsVO> children = new ArrayList<>();
            List<ProductCategory> sonProductCategory = productCategory.getSonProductCategory();
            for (ProductCategory category : sonProductCategory) {
                CategoryOptionsVO sonOptionsVO = new CategoryOptionsVO();
                sonOptionsVO.setValue(category.getId());
                sonOptionsVO.setLabel(category.getName());
                children.add(sonOptionsVO);
            }
            optionsVO.setChildren(children);
            optionsVOS.add(optionsVO);
        }
        return ResponseVO.builder().code("200").data(optionsVOS).build();
    }


    @PostMapping("/listById")
    public ResponseVO listById(Integer pageNum, Integer pageSize,Integer categoryId){
        PageInfo pageInfo = new PageInfo(productCategoryService.getByParentId(pageNum, pageSize, categoryId));
        return ResponseVO.builder().code("200").data(pageInfo).build();
    }

    @PostMapping("/listByParentId")
    public ResponseVO listByParentId(Integer parentId){
        List<ProductCategory> result = productCategoryService.getByParentId(parentId);
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/deleteById")
    public ResponseVO deleteById(Integer categoryId){
        Boolean result = productCategoryService.deleteById(categoryId);
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/deleteSonById")
    public ResponseVO deleteSonById(Integer categoryId){
        Boolean result = productCategoryService.deleteSonById(categoryId);
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PostMapping("/editCategory")
    public ResponseVO editCategory(@RequestBody ProductCategory productCategory){
        productCategoryService.editCategory(productCategory);
        return ResponseVO.builder().code("200").build();
    }

    @PostMapping("/insertCategory")
    public ResponseVO insertCategory(@RequestBody ProductCategory productCategory){
        productCategoryService.insertCategory(productCategory);
        return ResponseVO.builder().code("200").build();
    }


}

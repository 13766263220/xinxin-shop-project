package com.nf.controller.be;

import com.nf.entity.AttrOption;
import com.nf.service.AttrOptionService;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//设置跨域
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/attrOption")
public class AttrOptionController {
    @Autowired
    private AttrOptionService attrOptionService;

    @PostMapping("/insertAttrOption")
    public ResponseVO insertAttrOption(@RequestBody AttrOption attrOption) {
        attrOptionService.insertAttrOption(attrOption);
        return ResponseVO.builder().code("200").build();
    }

    @PostMapping("/deleteAttrOption")
    public ResponseVO deleteAttrOption(Integer optionId) {
        attrOptionService.deleteAttrOption(optionId);
        return ResponseVO.builder().code("200").build();
    }

}

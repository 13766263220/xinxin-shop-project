package com.nf.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.dto.OrderInfoDTO;
import com.nf.entity.CartItem;
import com.nf.entity.OrderInfo;
import com.nf.service.OrderInfoService;
import com.nf.service.ProductBrandService;
import com.nf.utils.CodecUtil;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @PostMapping("/addOrderInfo")
    public ResponseVO addOrderInfo(@RequestBody OrderInfoDTO orderInfoDTO){
        OrderInfo orderInfo = orderInfoDTO.getOrderInfo();
        orderInfo.setCreateTime(new Date());//提交时间
        orderInfo.setOrderSn(CodecUtil.createOrderId());

        CartItem[] cartItems = orderInfoDTO.getCartItems();
        orderInfoService.addOrder(orderInfo,cartItems);

        return ResponseVO.builder().code("200").build();
    }

    @GetMapping("/getByPhone")
    public ResponseVO list(String phone) {
        List<OrderInfo> result = orderInfoService.getByPhone(phone);
        return ResponseVO.builder().code("200").data(result).build();
    }

    @GetMapping("/getByPhoneAndStatus")
    public ResponseVO list(String phone,Integer status) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setReceiverPhone(phone);
        orderInfo.setStatus(status);
        List<OrderInfo> result = orderInfoService.getByPhoneAndStatus(orderInfo);
        return ResponseVO.builder().code("200").data(result).build();
    }

    @PutMapping("/editOrderInfo")
    public ResponseVO editOrderInfo(@RequestBody OrderInfo orderInfo){
        if(orderInfo.getStatus().equals(1)){//表示已支付
            // 付款时间
            orderInfo.setPaymentTime(new Date());
        }else if(orderInfo.getStatus().equals(2)){//表示已发货
            // 发货时间
            orderInfo.setDeliveryTime(new Date());
        }else if(orderInfo.getStatus().equals(3)){//表示已收货
            // 修改收货状态
            orderInfo.setConfirmStatus(1);
            //确认收货时间
            orderInfo.setReceiveTime(new Date());
        }

        orderInfoService.editOrderInfo(orderInfo);
        return ResponseVO.builder().code("200").msg("修改成功").build();
    }

    @PutMapping("/deleteById")
    public ResponseVO deleteById(Integer orderId){
        orderInfoService.deleteById(orderId);
        return ResponseVO.builder().code("200").msg("删除成功").build();
    }
}

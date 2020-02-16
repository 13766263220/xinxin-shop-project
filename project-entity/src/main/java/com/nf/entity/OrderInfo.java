package com.nf.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

//订单信息
@Data
public class OrderInfo {
    private Integer id; //订单id
    private String orderSn; //订单编号
    private Date createTime; //提交时间
    private String userName; //用户账号
    private BigDecimal totalAmount; //订单总金额
    private Integer payType; // 支付方式：0->未支付；1->支付宝；2->微信'
    private Integer status; //订单状态：0->待付款；1->待发货；2->已发货；3->确认收货；4->已关闭
    private String receiverName; // 收货人姓名
    private String receiverPhone; //收货人电话
    private String receiverDetailAddress; //收货详细地址
    private String note; //订单备注
    private Integer confirmStatus; //确认收货状态：0->未确认；1->已确认
    private Date paymentTime; //支付时间
    private Date deliveryTime; //发货时间
    private Date receiveTime; //确认收货时间
    private Date commentTime; //评价时间
}

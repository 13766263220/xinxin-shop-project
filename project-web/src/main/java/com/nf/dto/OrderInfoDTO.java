package com.nf.dto;

import com.nf.entity.CartItem;
import com.nf.entity.OrderInfo;
import lombok.Data;

import java.util.List;

@Data
public class OrderInfoDTO {
    private OrderInfo orderInfo;
    private CartItem[] cartItems;
}

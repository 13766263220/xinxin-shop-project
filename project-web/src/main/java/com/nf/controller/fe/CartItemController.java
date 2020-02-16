package com.nf.controller.fe;

import com.nf.entity.CartItem;
import com.nf.entity.Product;
import com.nf.entity.ProductStock;
import com.nf.service.CartItemService;
import com.nf.service.ProductService;
import com.nf.service.ProductStockService;
import com.nf.vo.CartItemVO;
import com.nf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ProductStockService productStockService;
    @Autowired
    private ProductService productService;

    @GetMapping("/cartItem/{userId}")
    public ResponseVO getByUserId(@PathVariable Integer userId){
        List<CartItem> result = cartItemService.getByUserId(userId);
        //获得购物车项附带的所有商品信息
        List<CartItemVO> cartItemVOList = getCartItemVOList(result);
        return ResponseVO.builder().code("200").msg("查询成功").data(cartItemVOList).build();
    }

    @GetMapping("/cartItem")
    public ResponseVO getOrderId(Integer orderId){
        List<CartItem> result = cartItemService.getByOrderId(orderId);
        //获得购物车项附带的所有商品信息
        List<CartItemVO> cartItemVOList = getCartItemVOList(result);
        return ResponseVO.builder().code("200").msg("查询成功").data(cartItemVOList).build();
    }

    @PostMapping("/cartItem")
    public ResponseVO addShoppingCart(@RequestBody CartItem cartItem){
        CartItem item = cartItemService.getByUserIdWithSkuId(cartItem);
        if(item == null || item.getOrderId() !=0){
            cartItemService.addShoppingCart(cartItem);
        }else{
            item.setQuantity(item.getQuantity() + 1);
            cartItemService.editShoppingCart(item);
        }
        return ResponseVO.builder().code("200").msg("添加成功").build();
    }

    @PutMapping("/cartItem")
    public ResponseVO editShoppingCart(@RequestBody CartItem cartItem){
        cartItemService.editShoppingCart(cartItem);
        //查询修改过后的值
        CartItem result = cartItemService.getByUserIdWithSkuId(cartItem);

        return ResponseVO.builder().code("200").msg("修改成功").data(result).build();
    }

    @DeleteMapping("/cartItem/{id}")
    public ResponseVO deleteShoppingCart(@PathVariable Integer id){
        cartItemService.deleteShoppingCart(id);
        return ResponseVO.builder().code("200").msg("删除成功").build();
    }

    private List<CartItemVO> getCartItemVOList(List<CartItem> result){
        List<CartItemVO> cartItemVOList = new ArrayList<>();
        for (CartItem cartItem : result) {
            CartItemVO cartItemVO = new CartItemVO();
            //商品库存
            ProductStock productStock = productStockService.getById(cartItem.getSkuId());
            if (productStock == null){
                return null;
            }
            cartItemVO.setProductStock(productStock);

            //商品信息
            Product product = productService.getById(productStock.getProductId());
            cartItemVO.setProduct(product);

            //购物车项
            cartItemVO.setCartItem(cartItem);

            cartItemVOList.add(cartItemVO);
        }
        return cartItemVOList;
    }


}

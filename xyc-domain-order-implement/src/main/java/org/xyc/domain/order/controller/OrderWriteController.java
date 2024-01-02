package org.xyc.domain.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xyc.domain.order.model.to.OrderTO;
import org.xyc.domain.order.service.OrderService;

/**
 * @author xuyachang
 * @date 2023/12/29
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("api/order")
public class OrderWriteController {
    private final OrderService orderService;

    @GetMapping("/create")
    public OrderTO createOrder(String buyerName, String buyerMobile, Long shopId){
        OrderTO orderTO = new OrderTO();
        orderTO.setOrderCode("12355");
        return orderTO;
    }
}

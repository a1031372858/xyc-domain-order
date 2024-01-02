package org.xyc.domain.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xyc.domain.order.model.po.OrderPO;
import org.xyc.domain.order.model.request.OrderCreateRequest;
import org.xyc.domain.order.model.to.OrderTO;
import org.xyc.domain.order.service.OrderService;

/**
 * @author xuyachang
 * @date 2023/12/29
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("api/order/read")
public class OrderReadController {
    private final OrderService orderService;

    @GetMapping("/get")
    public OrderTO findOrder(){
        return orderService.queryById(1L);
    }
}

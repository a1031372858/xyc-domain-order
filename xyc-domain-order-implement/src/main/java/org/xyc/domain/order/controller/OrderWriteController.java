package org.xyc.domain.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.xyc.domain.base.model.Response;
import org.xyc.domain.order.model.request.OrderCreateRequest;
import org.xyc.domain.order.model.to.OrderTO;
import org.xyc.domain.order.service.OrderService;

/**
 * @author xuyachang
 * @date 2023/12/29
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("api/order/write")
public class OrderWriteController {
    private final OrderService orderService;

    @PostMapping("/create")
    public Response<OrderTO> createOrder(@RequestBody OrderCreateRequest request){
        return Response.success(orderService.createOrder(request));
    }
}

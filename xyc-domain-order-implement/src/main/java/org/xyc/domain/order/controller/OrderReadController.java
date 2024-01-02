package org.xyc.domain.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.xyc.domain.order.service.OrderService;

/**
 * @author xuyachang
 * @date 2023/12/29
 */
@RequiredArgsConstructor
@RestController
public class OrderReadController {
    private final OrderService orderService;
}

package org.xyc.domain.order.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xyc.domain.base.model.Response;
import org.xyc.domain.order.model.to.OrderTO;
import org.xyc.domain.order.service.OrderService;

/**
 * @author xuyachang
 * @date 2024/5/17
 */
@RestController
@RequiredArgsConstructor
public class OrderReadFacadeImpl implements OrderReadFacade{

    private final OrderService orderService;

    @Override
    public Response<OrderTO> findOrder(OrderTO orderTO){
        return Response.success(orderService.queryById(1L));
    }
}

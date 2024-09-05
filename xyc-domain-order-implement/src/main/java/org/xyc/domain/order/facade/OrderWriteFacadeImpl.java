package org.xyc.domain.order.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xyc.domain.base.model.Response;
import org.xyc.domain.order.model.request.OrderCreateOrUpdateRequest;
import org.xyc.domain.order.model.request.OrderCreateRequest;
import org.xyc.domain.order.model.to.OrderTO;
import org.xyc.domain.order.service.OrderService;

/**
 * @author xuyachang
 * @date 2024/5/24
 */
@RestController
@RequiredArgsConstructor
public class OrderWriteFacadeImpl implements OrderWriteFacade{
    private final OrderService orderService;

    @Override
    public Response<OrderTO> createOrder(@RequestBody OrderCreateRequest request){
        return Response.success(orderService.createOrder(request));
    }

    @Override
    public Response<Boolean> updateOrderStatus(@RequestBody OrderTO orderTO){
        return Response.success(orderService.updateOrderStatus(orderTO));
    }

    @Override
    public Response<Boolean> updateOrderBuyerInfo(OrderTO orderTO) {
        return Response.success(orderService.updateOrderBuyerInfo(orderTO));
    }

    @Override
    public Response<Boolean> orderCreateOrUpdate(OrderCreateOrUpdateRequest request) {
        return Response.success(orderService.createOrUpdateOrder(request));
    }
}

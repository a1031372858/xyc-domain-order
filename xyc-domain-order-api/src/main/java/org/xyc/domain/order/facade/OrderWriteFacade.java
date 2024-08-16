package org.xyc.domain.order.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xyc.domain.base.model.Response;
import org.xyc.domain.order.model.request.OrderCreateRequest;
import org.xyc.domain.order.model.to.OrderTO;

/**
 * @author xuyachang
 * @date 2024/5/24
 */
@FeignClient(value = "xyc-order",contextId = "OrderWriteFacade")
public interface OrderWriteFacade {

    @PostMapping("/createOrder")
    Response<OrderTO> createOrder(@RequestBody OrderCreateRequest request);

    @PostMapping("/updateOrderStatus")
    Response<Boolean> updateOrderStatus(@RequestBody OrderTO orderTO);

    @PostMapping("/updateOrderBuyerInfo")
    Response<Boolean> updateOrderBuyerInfo(@RequestBody OrderTO orderTO);
}

package org.xyc.domain.order.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xyc.domain.base.model.Response;
import org.xyc.domain.order.model.to.OrderTO;

/**
 * @author xuyachang
 * @date 2024/5/17
 */
@FeignClient(value = "xyc-order",contextId = "OrderReadFacade")
public interface OrderReadFacade {

    @PostMapping("/findOrder")
    public Response<OrderTO> findOrder(@RequestBody OrderTO orderTO);
}

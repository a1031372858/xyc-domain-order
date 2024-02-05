package org.xyc.domain.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.xyc.domain.base.model.Response;
import org.xyc.domain.order.common.constant.OrderStatusConstant;
import org.xyc.domain.order.converter.OrderConverter;
import org.xyc.domain.order.mapper.OrderMapper;
import org.xyc.domain.order.model.po.OrderPO;
import org.xyc.domain.order.model.request.OrderCreateRequest;
import org.xyc.domain.order.model.to.OrderTO;
import org.xyc.domain.order.util.OrderHelper;

/**
 * @author xuyachang
 * @date 2023/12/29
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    private final OrderConverter orderConverter;

    public Response<OrderTO> queryById(Long id){
        OrderPO orderPO = orderMapper.selectById(id);
        return Response.success(orderConverter.convertT(orderPO));
    }

    public Response<OrderTO> createOrder(OrderCreateRequest request){
        OrderPO orderPO = new OrderPO();
        orderPO.setOrderCode(OrderHelper.getOrderCode());
        orderPO.setBuyerMobile(request.getBuyerMobile());
        orderPO.setBuyerName(request.getBuyerName());
        orderPO.setOrderStatus(OrderStatusConstant.CREATED);
        orderPO.setShopId(request.getShopId());
        orderMapper.insert(orderPO);
        return Response.success(orderConverter.convertT(orderPO));
    }

    public OrderTO findOrder(String orderCoe) {
        return new OrderTO();
    }
}

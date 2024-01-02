package org.xyc.domain.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.xyc.domain.order.mapper.OrderMapper;
import org.xyc.domain.order.model.po.OrderPO;
import org.xyc.domain.order.model.request.OrderCreateRequest;
import org.xyc.domain.order.model.to.OrderTO;

/**
 * @author xuyachang
 * @date 2023/12/29
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderTO queryById(Long id){
        OrderPO orderPO = orderMapper.selectById(id);

        OrderTO orderTO = new OrderTO();
        orderTO.setId(orderPO.getId());
        orderTO.setOrderCode(orderPO.getOrderCode());
        orderTO.setBuyerMobile(orderPO.getBuyerMobile());
        orderTO.setBuyerName(orderPO.getBuyerName());
        return orderTO;
    }

    public OrderTO createOrder(OrderCreateRequest request){
        OrderPO orderPO = new OrderPO();
        orderPO.setOrderCode("12355");
        orderPO.setBuyerMobile(request.getBuyerMobile());
        orderPO.setBuyerName(request.getBuyerName());
        orderPO.setOrderStatus(10);
        orderPO.setShopId(request.getShopId());
        orderMapper.insert(orderPO);
        OrderTO orderTO = new OrderTO();
        orderTO.setOrderCode(orderPO.getOrderCode());
        return orderTO;
    }

    public OrderTO findOrder(String orderCoe) {
        return new OrderTO();
    }
}

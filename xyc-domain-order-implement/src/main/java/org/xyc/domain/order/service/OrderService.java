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

    public OrderTO queryById(Long id){
        return orderConverter.convertT(orderMapper.selectById(id));
    }

    public OrderTO createOrder(OrderCreateRequest request){
        OrderPO orderPO = new OrderPO();
        orderPO.setOrderCode(OrderHelper.getOrderCode());
        orderPO.setBuyerMobile(request.getBuyerMobile());
        orderPO.setBuyerName(request.getBuyerName());
        orderPO.setOrderStatus(OrderStatusConstant.CREATED);
        orderPO.setShopId(request.getShopId());
        orderMapper.insert(orderPO);
        return orderConverter.convertT(orderPO);
    }

    public Boolean updateOrderStatus(OrderTO orderTO){
        OrderPO orderPO = new OrderPO();
        orderPO.setId(orderTO.getId());
        orderPO.setOrderStatus(orderTO.getOrderStatus());
        orderMapper.updateById(orderPO);
        return Boolean.TRUE;
    }

}

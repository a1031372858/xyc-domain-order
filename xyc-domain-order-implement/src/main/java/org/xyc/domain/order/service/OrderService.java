package org.xyc.domain.order.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xyc.domain.order.common.constant.OrderStatusConstant;
import org.xyc.domain.order.converter.OrderConverter;
import org.xyc.domain.order.mapper.OrderMapper;
import org.xyc.domain.order.model.po.OrderPO;
import org.xyc.domain.order.model.request.OrderCreateRequest;
import org.xyc.domain.order.model.to.OrderTO;
import org.xyc.domain.order.util.OrderHelper;

import java.util.Objects;

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
//    @Transactional
    public Boolean updateOrderBuyerInfo(OrderTO orderTO) {
        OrderPO orderPO = new OrderPO();
        if(Objects.nonNull(orderTO.getBuyerName())){
            orderPO.setBuyerName(orderTO.getBuyerName());
        }
        if(Objects.nonNull(orderTO.getBuyerMobile())){
            orderPO.setBuyerMobile(orderTO.getBuyerMobile());
        }
        UpdateWrapper<OrderPO> orderPOUpdateWrapper = new UpdateWrapper<>();
        orderPOUpdateWrapper.eq("buyer_id",orderTO.getBuyerId());
        orderMapper.update(orderPO, orderPOUpdateWrapper);
        return Boolean.TRUE;
    }
}

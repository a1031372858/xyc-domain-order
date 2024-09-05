package org.xyc.domain.order.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xyc.domain.order.common.constant.OrderStatusConstant;
import org.xyc.domain.order.converter.OrderConverter;
import org.xyc.domain.order.mapper.OrderMapper;
import org.xyc.domain.order.model.po.OrderPO;
import org.xyc.domain.order.model.request.OrderCreateOrUpdateRequest;
import org.xyc.domain.order.model.request.OrderCreateRequest;
import org.xyc.domain.order.model.to.OrderTO;
import org.xyc.domain.order.util.OrderHelper;

import java.util.List;
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

    private final OrderHelper orderHelper;

    public OrderTO queryById(Long id){
        return orderConverter.convertT(orderMapper.selectById(id));
    }

    public OrderTO createOrder(OrderCreateRequest request){
        OrderPO orderPO = new OrderPO();
        orderPO.setOrderCode(orderHelper.getOrderCode());
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

    /**
     * 第三方订单创建和更新
     * @param request
     * @return
     */
    public Boolean createOrUpdateOrder(OrderCreateOrUpdateRequest request) {
        if(Objects.isNull(request)|| Objects.isNull(request.getOrderTO())){
            return Boolean.TRUE;
        }
        OrderPO orderPO = orderConverter.convertP(request.getOrderTO());
        orderPO.setOrderCode(orderHelper.getOrderCode());
        QueryWrapper<OrderPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("third_party_order_code",orderPO.getThirdPartyOrderCode());
        queryWrapper.eq("third_party_channel_code",orderPO.getThirdPartyChannelCode());
        OrderPO dbOrderPO = orderMapper.selectOne(queryWrapper);
        if(Objects.isNull(dbOrderPO)){
            orderMapper.insert(orderPO);
        }else{
            OrderPO updateOrder = new OrderPO();
            updateOrder.setId(dbOrderPO.getId());
            updateOrder.setOrderStatus(orderPO.getOrderStatus());
            orderMapper.updateById(updateOrder);
        }
        return Boolean.TRUE;
    }
}

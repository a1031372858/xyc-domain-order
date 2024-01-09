package org.xyc.domain.order.converter;

import org.mapstruct.Mapper;
import org.xyc.domain.order.base.BaseConverter;
import org.xyc.domain.order.model.po.OrderPO;
import org.xyc.domain.order.model.to.OrderTO;

/**
 * @author xuyachang
 * @date 2024/1/4
 */
@Mapper(componentModel = "spring")
public abstract class OrderConverter extends BaseConverter<OrderTO,OrderPO> {
}

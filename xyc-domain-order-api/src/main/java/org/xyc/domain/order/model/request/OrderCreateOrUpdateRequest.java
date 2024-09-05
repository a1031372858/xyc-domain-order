package org.xyc.domain.order.model.request;

import lombok.Data;
import org.xyc.domain.order.model.to.OrderTO;

/**
 * @author xuyachang
 * @date 2024/9/3
 */
@Data
public class OrderCreateOrUpdateRequest {
    private OrderTO orderTO;
}

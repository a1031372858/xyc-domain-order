package org.xyc.domain.order.model.request;

import lombok.Data;

/**
 * @author xuyachang
 * @date 2024/1/2
 */
@Data
public class OrderCreateRequest {
    String buyerName;
    String buyerMobile;
    Long shopId;
}

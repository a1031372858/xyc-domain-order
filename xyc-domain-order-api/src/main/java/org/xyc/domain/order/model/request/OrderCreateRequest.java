package org.xyc.domain.order.model.request;

import lombok.Data;

/**
 * @author xuyachang
 * @date 2024/1/2
 */
@Data
public class OrderCreateRequest {
    private Long buyerId;
    private String buyerName;
    private String buyerMobile;
    private Long shopId;
}

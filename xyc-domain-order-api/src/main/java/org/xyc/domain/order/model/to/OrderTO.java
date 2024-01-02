package org.xyc.domain.order.model.to;

import lombok.Data;

/**
 * @author xuyachang
 * @date 2023/8/10
 */
@Data
public class OrderTO {
    private String orderCode;
    private Integer orderStatus;
    private String buyerName;
    private String buyerMobile;
    private Long shopId;
}

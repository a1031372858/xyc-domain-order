package org.xyc.domain.order.model.to;

import lombok.Data;

/**
 * @author xuyachang
 * @date 2023/8/10
 */
@Data
public class OrderTO {
    private Long id;
    private String orderCode;
    private Integer orderStatus;
    private String buyerName;
    private String buyerMobile;
    private Long shopId;
}

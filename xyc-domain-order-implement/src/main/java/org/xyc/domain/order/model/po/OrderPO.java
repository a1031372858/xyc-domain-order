package org.xyc.domain.order.model.po;

import lombok.Data;
import org.xyc.domain.base.model.ModelBase;

/**
 * @author xuyachang
 * @date 2023/12/29
 */
@Data
public class OrderPO extends ModelBase<OrderPO> {
    private String orderCode;
    private String orderStatus;
    private String buyerName;
    private String buyerMobile;
    private Long shopId;
}

package org.xyc.domain.order.model.to;

import lombok.Data;
import org.xyc.domain.base.model.ModelBase;

/**
 * @author xuyachang
 * @date 2023/8/10
 */
@Data
public class OrderTO extends ModelBase {
    private String orderCode;
    private String orderStatus;
    private String buyerName;
    private String buyerMobile;
    private Long shopId;
}

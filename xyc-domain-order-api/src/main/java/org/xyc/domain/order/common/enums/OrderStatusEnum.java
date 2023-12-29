package org.xyc.domain.order.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author xuyachang
 * @date 2023/8/10
 */
@AllArgsConstructor
@Getter
public enum OrderStatusEnum {
    CREATE(10,"10","订单创建"),
    PAID(20,"20","已支付"),
    DONE(30,"20","已完成"),
    CLOSED(40,"20","已关闭"),
    CANCELLED(50,"20","已取消");

    private Integer value;
    private String code;
    private String desc;
}

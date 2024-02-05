package org.xyc.domain.order.common.constant;

/**
 * 订单状态常量
 * @author xuyachang
 * @date 2024/2/5
 */
public interface OrderStatusConstant {
    /**
     * 订单创建
     */
    String CREATED = "CREATED";
    /**
     * 已支付
     */
    String PAID = "PAID";
    /**
     * 已完成
     */
    String DONE = "DONE";
    /**
     * 已关闭
     */
    String CLOSED = "CLOSED";
    /**
     * 已取消
     */
    String CANCELLED = "CANCELLED";
}

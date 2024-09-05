package org.xyc.domain.order.model.to;

import lombok.Data;
import org.xyc.domain.base.model.ModelBase;

import java.math.BigDecimal;

/**
 * @author xuyachang
 * @date 2023/8/10
 */
@Data
public class OrderTO extends ModelBase {
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 买家Id
     */
    private Long buyerId;
    /**
     * 买家名称
     */
    private String buyerName;
    /**
     * 买家手机号
     */
    private String buyerMobile;
    /**
     * 收货地址
     */
    private String shippingAddress;
    /**
     * 买家地址经度
     */
    private String buyerLng;

    /**
     * 买家地址纬度
     */
    private String buyerLat;
    /**
     * 门店Id
     */
    private Long shopId;
    /**
     * 门店名称
     */
    private String shopName;
    /**
     * 需要支付金额 单位:分
     */
    private BigDecimal needPaidAmt;
    /**
     * 支付金额 单位:分
     */
    private BigDecimal paidAmt;
    /**
     * 运费金额 单位:分
     */
    private BigDecimal shippingAmt;
    /**
     * 商品金额 单位:分
     */
    private BigDecimal skuAmt;

    /**
     * 第三方订单编码
     */
    private String thirdPartyOrderCode;

    /**
     * 第三方平台编码
     */
    private String thirdPartyChannelCode;
}

package org.xyc.domain.order.utils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuyachang
 * @date 2024/1/3
 */
public class OrderHelper {

    public static final String ORDER_PREFIX = "T";
    private static final AtomicInteger orderNo = new AtomicInteger(0);

    /**
     * 生成订单编码
     * @return
     */
    public static String getOrderCode(){
        int no = orderNo.addAndGet(1);
        String date = DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN);
        String orderNoStr = StrUtil.fillBefore(String.valueOf(no), '0', 8);
        return ORDER_PREFIX + date + orderNoStr;
    }
}

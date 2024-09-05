package org.xyc.domain.order.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.xyc.domain.order.common.RedisKey;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuyachang
 * @date 2024/1/3
 */
@Component
@RequiredArgsConstructor
public class OrderHelper {

    public static final String ORDER_PREFIX = "T";

    private final StringRedisTemplate stringRedisTemplate;

    private static final AtomicInteger orderNo = new AtomicInteger(0);

    /**
     * 生成订单编码
     * @return
     */
    public String getOrderCode(){
        Long no = stringRedisTemplate.opsForValue().increment(RedisKey.ORDER_NO_KEY);
        String date = DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN);
        String orderNoStr = StrUtil.fillBefore(String.valueOf(no), '0', 8);
        return ORDER_PREFIX + date + orderNoStr;
    }
}

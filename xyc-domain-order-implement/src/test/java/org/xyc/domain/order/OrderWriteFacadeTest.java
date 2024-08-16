package org.xyc.domain.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.xyc.domain.order.common.constant.OrderStatusConstant;
import org.xyc.domain.order.facade.OrderWriteFacade;
import org.xyc.domain.order.model.request.OrderCreateRequest;
import org.xyc.domain.order.model.to.OrderTO;

/**
 * @author xuyachang
 * @date 2024/6/11
 */

@EnableAutoConfiguration
@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderWriteFacadeTest {

    @Autowired
    private OrderWriteFacade orderWriteFacade;

    @Test
    public void createOrder(){
        OrderCreateRequest createRequest = new OrderCreateRequest();
        createRequest.setBuyerId(1L);
        createRequest.setShopId(1L);
        createRequest.setBuyerMobile("15797704512");
        createRequest.setBuyerName("测试用户");
        orderWriteFacade.createOrder(createRequest);
    }

    @Test
    public void updateOrderStatus(){
        OrderTO orderTO = new OrderTO();
        orderTO.setId(1L);
        orderTO.setOrderStatus(OrderStatusConstant.CANCELLED);
        orderWriteFacade.updateOrderStatus(orderTO);
    }
}

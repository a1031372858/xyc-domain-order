package org.xyc.domain.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.xyc.domain.base.util.Assert;
import org.xyc.domain.order.facade.OrderReadFacade;
import org.xyc.domain.order.model.to.OrderTO;

/**
 * @author xuyachang
 * @date 2024/6/2
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderReadFacadeTest{

    @Autowired
    private OrderReadFacade orderReadFacade;

    @Test
    public void findOrder(){
        OrderTO orderTO = new OrderTO();
        orderTO.setId(1L);
        OrderTO result = Assert.getResult(orderReadFacade.findOrder(orderTO));
        System.out.println(result);
    }
}

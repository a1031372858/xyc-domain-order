package org.xyc.domain.order;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xyc.domain.order.model.to.OrderTO;

/**
 * @author xuyachang
 * @date ${DATE}
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        OrderTO orderTO = new OrderTO();
        System.out.println(orderTO);
        System.out.println("Hello world!");
    }
}
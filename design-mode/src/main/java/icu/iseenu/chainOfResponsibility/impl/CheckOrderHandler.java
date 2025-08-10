package icu.iseenu.chainOfResponsibility.impl;

import icu.iseenu.chainOfResponsibility.Order;
import icu.iseenu.chainOfResponsibility.OrderHandler;

public class CheckOrderHandler implements OrderHandler {
    private OrderHandler next;

    public void setNext(OrderHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Order order) {
        // 检查订单信息是否完整
        if (order.isInfoComplete()) {
            // 如果订单信息完整，则将请求传递给下一个处理者
            next.handle(order);
        } else {
            // 如果订单信息不完整，则直接返回错误信息
            throw new RuntimeException("订单信息不完整");
        }
    }
}

package icu.iseenu.chainOfResponsibility.impl;

import icu.iseenu.chainOfResponsibility.Order;
import icu.iseenu.chainOfResponsibility.OrderHandler;

public class CheckBalanceHandler implements OrderHandler {
    private OrderHandler next;

    public void setNext(OrderHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Order order) {
        // 检查用户余额是否充足
        if (order.getBalance() >= order.getAmount()) {
            // 如果余额充足，则将请求传递给下一个处理者
            next.handle(order);
        } else {
            // 如果余额不足，则直接返回错误信息
            throw new RuntimeException("用户余额不足");
        }
    }

}
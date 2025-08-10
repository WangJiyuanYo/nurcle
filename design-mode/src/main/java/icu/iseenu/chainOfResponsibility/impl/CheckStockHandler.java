package icu.iseenu.chainOfResponsibility.impl;

import icu.iseenu.chainOfResponsibility.Order;
import icu.iseenu.chainOfResponsibility.OrderHandler;

public class CheckStockHandler implements OrderHandler {
    private OrderHandler next;

    public void setNext(OrderHandler next) {
        this.next = next;
    }
    @Override
    public void handle(Order order) {
        // 检查商品库存是否充足
        if (order.getStock() >= order.getQuantity()) {
            // 如果库存充足，则将请求传递给下一个处理者
            next.handle(order);
        } else {
            // 如果库存不足，则直接返回错误信息
            throw new RuntimeException("商品库存不足");
        }
    }
}

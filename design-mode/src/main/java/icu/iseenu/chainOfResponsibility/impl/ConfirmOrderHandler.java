package icu.iseenu.chainOfResponsibility.impl;

import icu.iseenu.chainOfResponsibility.Order;
import icu.iseenu.chainOfResponsibility.OrderHandler;

public class ConfirmOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        // 确认订单，更新商品库存和用户余额
        order.confirm();
    }


}
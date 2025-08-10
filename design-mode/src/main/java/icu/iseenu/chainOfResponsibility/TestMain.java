package icu.iseenu.chainOfResponsibility;

import icu.iseenu.chainOfResponsibility.impl.CheckBalanceHandler;
import icu.iseenu.chainOfResponsibility.impl.CheckOrderHandler;
import icu.iseenu.chainOfResponsibility.impl.CheckStockHandler;
import icu.iseenu.chainOfResponsibility.impl.ConfirmOrderHandler;

public class TestMain {
    public static void main(String[] args) {
        CheckOrderHandler checkOrderHandler = new CheckOrderHandler();
        CheckStockHandler checkStockHandler = new CheckStockHandler();
        CheckBalanceHandler checkBalanceHandler = new CheckBalanceHandler();
        ConfirmOrderHandler confirmOrderHandler = new ConfirmOrderHandler();


        // 将处理器按照一定顺序组成责任链
        checkOrderHandler.setNext(checkStockHandler);
        checkStockHandler.setNext(checkBalanceHandler);
        checkBalanceHandler.setNext(confirmOrderHandler);

        // 处理订单
        Order order = new Order();
        checkOrderHandler.handle(order);
    }
}

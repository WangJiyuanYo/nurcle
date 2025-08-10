package icu.iseenu.stateModel.impl;

import icu.iseenu.stateModel.Order;
import icu.iseenu.stateModel.OrderState;

public class PaidState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new ShippedState());
    }

    @Override
    public void previous(Order order) {
        order.setState(new CreatedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order paid.");
    }
}
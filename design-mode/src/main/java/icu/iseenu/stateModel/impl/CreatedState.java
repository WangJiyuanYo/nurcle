package icu.iseenu.stateModel.impl;

import icu.iseenu.stateModel.Order;
import icu.iseenu.stateModel.OrderState;

public class CreatedState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new PaidState());
    }

    @Override
    public void previous(Order order) {
        System.out.println("The order is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Order created.");
    }
}
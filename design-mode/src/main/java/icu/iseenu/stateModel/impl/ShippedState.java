package icu.iseenu.stateModel.impl;

import icu.iseenu.stateModel.Order;
import icu.iseenu.stateModel.OrderState;

public class ShippedState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order shipped");
    }

    @Override
    public void previous(Order order) {
        order.previousStep();
    }

    @Override
    public void printStatus() {
        System.out.println("Order shipped");
    }
}

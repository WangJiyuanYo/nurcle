package icu.iseenu.stateModel;

public class StateModelTestMain {
    public static void main(String[] args) {
        Order order = new Order();

        order.printStatus();

        order.nextStep();
        order.printStatus();

        order.previousStep();
        order.printStatus();


        order.nextStep();
        order.printStatus();
    }
}

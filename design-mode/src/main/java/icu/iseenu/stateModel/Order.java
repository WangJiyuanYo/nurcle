package icu.iseenu.stateModel;

import icu.iseenu.stateModel.impl.CreatedState;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private OrderState state;

    public Order() {
        // 订单初始化状态为已创建
        this.state = new CreatedState();
    }

    public void nextStep() {
        state.next(this);
    }

    public void previousStep() {
        state.previous(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}

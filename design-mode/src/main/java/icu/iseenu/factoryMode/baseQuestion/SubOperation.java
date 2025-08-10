package icu.iseenu.factoryMode.baseQuestion;

public class SubOperation extends BaseOperation {
    @Override
    public double getResult() {
        return getValue1() - getValue2();
    }
}

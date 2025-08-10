package icu.iseenu.factoryMode.factoryMethod;

import icu.iseenu.factoryMode.baseQuestion.BaseOperation;

public class TestMain {
    public static void main(String[] args) {
        IFactory factory = new AddFactory();
        BaseOperation operation = factory.createOption();
        operation.setValue1(1);
        operation.setValue2(1);
        System.out.println(operation.getResult());
    }
}

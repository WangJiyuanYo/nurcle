package icu.iseenu.factoryMode.simpleFactory;

import icu.iseenu.factoryMode.baseQuestion.BaseOperation;

public class TestMain {
    public static void main(String[] args) {
        BaseOperation baseOperation = OperationFactory.creationOperation("+");
        baseOperation.setValue1(11);
        baseOperation.setValue2(10);
        System.out.println(baseOperation.getResult());
    }
}

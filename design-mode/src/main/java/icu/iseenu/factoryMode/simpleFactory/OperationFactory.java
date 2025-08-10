package icu.iseenu.factoryMode.simpleFactory;

import icu.iseenu.factoryMode.baseQuestion.AddOperation;
import icu.iseenu.factoryMode.baseQuestion.BaseOperation;
import icu.iseenu.factoryMode.baseQuestion.SubOperation;

public class OperationFactory {
    public static BaseOperation creationOperation(String operation) {
        BaseOperation oper = null;
        switch (operation) {
            case "+":
                oper = new AddOperation();
                break;
            case "-":
                oper = new SubOperation();
                break;
            default:
                throw new UnsupportedOperationException("不支持该操作");
        }
        return oper;
    }
}

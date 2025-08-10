package icu.iseenu.factoryMode.factoryMethod;

import icu.iseenu.factoryMode.baseQuestion.AddOperation;
import icu.iseenu.factoryMode.baseQuestion.BaseOperation;

public class AddFactory implements IFactory{
    @Override
    public BaseOperation createOption() {
        return new AddOperation();
    }
}

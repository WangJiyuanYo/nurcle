package icu.iseenu.factoryMode.factoryMethod;

import icu.iseenu.factoryMode.baseQuestion.AddOperation;
import icu.iseenu.factoryMode.baseQuestion.BaseOperation;
import icu.iseenu.factoryMode.baseQuestion.SubOperation;

public class SubFactory implements IFactory {
    @Override
    public BaseOperation createOption() {
        return new SubOperation();
    }
}

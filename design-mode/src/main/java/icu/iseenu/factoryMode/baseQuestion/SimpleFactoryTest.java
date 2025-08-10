package icu.iseenu.factoryMode.baseQuestion;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        AddOperation addOperation = new AddOperation();
        addOperation.setValue1(10);
        addOperation.setValue2(10);

        System.out.println(addOperation.getResult());
    }
}

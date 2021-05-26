package practice.harish.designpatterns.factorymethod.calculator;

public class TestDemo {

    public static void main(String[] args) {
        Operation operation = OperationFactory.getOperationObject("-");
        operation.setA(20);
        operation.setB(30);
        System.out.println(operation.getResult());
    }
}

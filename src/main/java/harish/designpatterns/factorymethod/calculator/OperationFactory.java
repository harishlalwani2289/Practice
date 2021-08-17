package harish.designpatterns.factorymethod.calculator;

public class OperationFactory {

    public static Operation getOperationObject(String operator) {

        Operation operation = null;
        switch (operator) {
            case "+":
                return new AdditionOperation();
            case "-":
                return new SubstractionOperation();
        }
        return new Operation();
    }
}

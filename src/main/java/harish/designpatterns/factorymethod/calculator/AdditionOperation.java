package harish.designpatterns.factorymethod.calculator;

public class AdditionOperation  extends Operation{

    @Override
    public double getResult() {
        return getA() + getB();
    }
}

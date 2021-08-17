package harish.designpatterns.factorymethod.calculator;

public class SubstractionOperation extends Operation{

    @Override
    public double getResult() {
        return getA() - getB();
    }
}

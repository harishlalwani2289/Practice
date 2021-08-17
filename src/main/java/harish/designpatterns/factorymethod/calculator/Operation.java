package harish.designpatterns.factorymethod.calculator;

public class Operation {

    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getResult() {
        int result = 0;
        return result;
    }
}

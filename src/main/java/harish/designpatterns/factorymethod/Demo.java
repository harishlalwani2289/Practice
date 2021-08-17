package harish.designpatterns.factorymethod;

public class Demo {

    public static void main(String[] args) {
        Point point = Point.Factory.newCartesianPoint(2,3);
    }
}

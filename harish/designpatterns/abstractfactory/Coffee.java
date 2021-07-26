package practice.harish.designpatterns.abstractfactory;

public class Coffee implements HotDrink{
    @Override
    public void consume() {
        System.out.println("this coffee is delicious.");
    }
}

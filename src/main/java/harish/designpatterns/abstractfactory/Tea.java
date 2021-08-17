package harish.designpatterns.abstractfactory;

public class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("The tea is delicious.");
    }
}

package practice.harish.designpatterns.abstractfactory;

public class CoffeeFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("We need to grind some beans, pour" + amount + " ml of water, enjoy");
        return new Coffee();
    }
}

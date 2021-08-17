package harish.designpatterns.factorypattern;

public class TestCarFactory {
	public static void main(String arg[]) throws Exception{
		Car car = CarFactory.getInstance("sedan");
		car.show();
	}

}

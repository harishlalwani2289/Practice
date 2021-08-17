package harish.designpatterns.factorypattern;

public class CarFactory {
	
	public static Car getInstance(String carType) throws Exception{
		
		if(carType.equalsIgnoreCase("small"))
			return new SmallCar();
		else if (carType.equalsIgnoreCase("sedan"))
			return new Sedan();
		else if (carType.equalsIgnoreCase("Luxury"))
			return new Luxury();
		else
			return null;
		
	}

}

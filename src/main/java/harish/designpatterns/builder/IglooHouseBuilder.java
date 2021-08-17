package harish.designpatterns.builder;

public class IglooHouseBuilder implements HouseBuilder {

	private House house;
	
	
	public IglooHouseBuilder() {
		super();
		this.house = new House();
	}

	@Override
	public void buildBasement() {
		// TODO Auto-generated method stub
		house.setBasement("Ice Bars");

	}

	@Override
	public void buildStructure() {
		// TODO Auto-generated method stub
		house.setStructure("Ice Blocks");

	}

	@Override
	public void bulidRoof() {
		// TODO Auto-generated method stub
		house.setRoof("Ice Dome");

	}

	@Override
	public void buildInterior() {
		// TODO Auto-generated method stub
		house.setInterior("Ice Carvings");
	}

	@Override
	public House getHouse() {
		// TODO Auto-generated method stub
		return house;
	}

}

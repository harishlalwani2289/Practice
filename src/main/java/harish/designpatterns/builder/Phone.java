package harish.designpatterns.builder;

public class Phone {
	
	private String os;
	private String battery;
	private double screen;
	private String brand;
	
	
	
	public Phone(String os, String battery, double screen, String brand) {
		super();
		this.os = os;
		this.battery = battery;
		this.screen = screen;
		this.brand = brand;
	}
	
	public void setOs(String os) {
		this.os = os;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public void setScreen(double screen) {
		this.screen = screen;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Phone [os=" + os + ", battery=" + battery + ", screen=" + screen + ", brand=" + brand + "]";
	}
	
	
	
	

}

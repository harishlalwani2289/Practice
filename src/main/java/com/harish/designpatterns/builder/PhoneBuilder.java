package com.harish.designpatterns.builder;

public class PhoneBuilder {
	
	private String os;
	private String battery;
	private double screen;
	private String brand;
	
	
	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}
	public PhoneBuilder setBattery(String battery) {
		this.battery = battery;
		return this;
	}
	public PhoneBuilder setScreen(double screen) {
		this.screen = screen;
		return this;
	}
	public PhoneBuilder setBrand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public Phone getPhone(){
		return new Phone(os, battery, screen, brand);
	}
	
	

}

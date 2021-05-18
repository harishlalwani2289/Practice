package practice.harish.designpatterns.builder;

public class Shop {
	
	public static void main(String args[]){
		
		Phone phone = new PhoneBuilder().setBattery("2222").setBrand("Samsung").getPhone();
		
		System.out.println(phone);
	}

}

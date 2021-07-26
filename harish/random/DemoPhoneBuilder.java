package practice.harish.random;

public class DemoPhoneBuilder {

    public static void main(String[] args) {


         Phone phone  = PhoneBuilder.getBuilder()
                .setPhoneName("Galaxy A71")
                .setPhoneSize(6)
                .setCompanyName("Samsung")
                .build();

        System.out.println("Phone name is :" + phone.getName());
    }
}

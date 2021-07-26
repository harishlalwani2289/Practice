package practice.harish.random;

public class PhoneBuilder {

    private Phone phone;
    private static PhoneBuilder phoneBuilder;

    public PhoneBuilder(){
        phone = new Phone();
    }

    public static  PhoneBuilder getBuilder() {
        phoneBuilder = new PhoneBuilder();
        return phoneBuilder;
    }

    public PhoneBuilder setPhoneName(String name) {
        phone.setName(name);
        return phoneBuilder;
    }

    public PhoneBuilder setPhoneSize(int size) {
        phone.setSize(size);
        return phoneBuilder;
    }

    public PhoneBuilder setCompanyName(String name) {
        phone.setCompany(name);
        return phoneBuilder;
    }

    public Phone build() {
        return phone;
    }
}

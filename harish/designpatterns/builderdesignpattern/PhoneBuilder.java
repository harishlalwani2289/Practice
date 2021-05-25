package practice.harish.designpatterns.builderdesignpattern;

public class PhoneBuilder {

    private Phone phone = new Phone();
    public Phone build() {
        return phone;
    }

    public PhoneBuilder addName(String name){
        phone.setName(name);
        return this;
    }

    public PhoneBuilder addSize(int size) {
        phone.setSize(2);
        return this;
    }
}
package practice.harish.designpatterns.prototype.copyconstructor;

import org.apache.commons.math3.analysis.function.Add;

public class Address {


    public String street, city, country;

    //Copy constructor

    public Address(Address other) {
        this(other.street, other.city, other.country);
    }

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

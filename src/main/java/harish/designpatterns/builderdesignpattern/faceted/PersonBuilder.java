package harish.designpatterns.builderdesignpattern.faceted;

// facade Builder
public class PersonBuilder {

    protected Person person = new Person();


    public Person build() {
        return person;
    }

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

}

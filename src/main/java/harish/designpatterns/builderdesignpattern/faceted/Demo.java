package harish.designpatterns.builderdesignpattern.faceted;

public class Demo {

    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();

        Person person = personBuilder.lives()
                .at("1st Street")
                .in("Raipur")
                .withPostcode("492001")
                .works()
                .asA("SE")
                .at("amazon")
                .earning(200000)
                .build();

        System.out.println(person);
    }
}

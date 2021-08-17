package harish.designpatterns.builderdesignpattern;

public class Demo {

    public static void main(String[] args) {

        HtmlBuilder builder = new HtmlBuilder("ul");
        builder
            .addChild("li", "hello")
            .addChild("li", "world");
        System.out.println(builder);

        PhoneBuilder phoneBuilder = new PhoneBuilder();
        Phone nokia = phoneBuilder.addName("Nokia").addSize(2).build();
        System.out.println("Phone name is :" + nokia.getName() + " with size :" + nokia.getSize());


        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.withName("Harish").build();

        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
//        employeeBuilder.withName("Monty"). We don't have a method for worksAt because it returns us the reference of Person Builder
        Person monty = employeeBuilder.withName("Monty").worksAt("Developer").build();
        System.out.println(monty);

    }
}

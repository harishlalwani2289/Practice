package practice.harish.designpatterns.prototype;


import practice.harish.designpatterns.prototype.copyconstructor.Employee;

public class Demo extends Object {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person john = new Person(new String[]{"John", "Smith"}, new Address("London road", 123));

        Person jane = (Person) john.clone();
        jane.names[0] = "Jane";
        jane.address.houseNumber = 124;

        System.out.println(john);
        System.out.println(jane);


        Employee john2 = new Employee("John",
                new practice.harish.designpatterns.prototype.copyconstructor.Address("123 Road", "London", "UKK"));

        Employee chris = new Employee(john2);

        chris.name = "Chris";
        chris.address.city = "Mumbai";
        System.out.println(john2);
        System.out.println(chris);



    }
}

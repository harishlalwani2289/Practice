package practice.harish.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Accolite {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Sunny", 24, "ABC"),
                new Person("shankar", 19, "BCD"),
                new Person("Avani", 25, "Accolite"),
                new Person("Bob", 20, "XYZ"),
                new Person("Sumit", 23, "Accolite Digital"),
                new Person("shubham", 23, "Accolite"));

//        personList.stream()
//                .filter(p -> p.getCompany().contains("Accolite") && p.getAge() >20)
//                .forEach(p -> System.out.println(p.getName()));

        personList.stream()
                .filter(p -> p.getName().charAt(0) == 's' || p.getName().charAt(0) == 'S')
                .map(p -> p.getName())
                .sorted()
                .forEach(p -> System.out.println(p));

    }
}

class Person{
    private String name;
    private String company;
    private int age;

    public Person(String name, int age, String company) {
        this.name = name;
        this.company = company;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

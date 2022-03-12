package harish.hashmappractice;

import java.util.Objects;

public class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int hashCode() {
        return age % 54;
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }
}

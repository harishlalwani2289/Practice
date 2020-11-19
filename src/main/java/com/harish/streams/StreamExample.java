package com.harish.streams;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamExample {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Harish", "Lalwani", 29),
                new Person("Sanchit", "Kumar", 26),
                new Person("Amitosh", "Mishra", 30),
                new Person("Aswini", "Baliarsingh", 31),
                new Person("Surya", "Menon", 29),
                new Person("Akash", "Hinger", 29));

        Integer maxAge = people.stream()
                .filter(person -> person.getFirstName().startsWith("A"))
                .map(StreamExample::apply)
                .max(Comparator.comparing(User::getAge))
                .get().getAge();
               // .forEach(user -> System.out.println(user.toString()));

        System.out.println(maxAge);

        Person person = new Person("Akhil", "Hardwani", 29);
        person.setDateOfBirth(new GregorianCalendar(1998, Calendar.NOVEMBER, 11));
        System.out.println(new SimpleDateFormat("E, MMMM dd yyyy").format(person.getDateOfBirth().getTime()));
        System.out.println(person.getDateOfBirth().getTime());
    }

    private static User apply(Person person) {
        return new User(person.getFirstName() + " " + person.getLastName(), person.getAge());
    }
}

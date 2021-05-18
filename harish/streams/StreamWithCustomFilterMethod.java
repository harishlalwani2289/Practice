package practice.harish.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWithCustomFilterMethod {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Harish", "Lalwani", 29),
                new Person("Sanchit", "Kumar", 26),
                new Person("AmitoSh", "Mishra", 30),
                new Person("Aswini", "Baliarsingh", 31),
                new Person("Surya", "Menon", 29),
                new Person("Akash", "Hinger", 29));

        List<Person> validPersons = people.stream().filter(StreamWithCustomFilterMethod::containsSInFirstName)
                .collect(Collectors.toList());

        validPersons.stream()
                .forEach(person -> System.out.println(person));

    }

    private static boolean containsSInFirstName(Person person) {

        return person.getFirstName().contains("s") || person.getFirstName().contains("S");
    }
}

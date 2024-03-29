package harish.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMapExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2,3,4,5,6,7,8,2);
        List<String> names = Arrays.asList("Harish", "Sanchit", "Amitosh", "Vamsi", "Surya", "Akash", "Aswini");

        List<Person> people = Arrays.asList(
                new Person("Harish", "Lalwani", 29),
                new Person("Sanchit", "Kumar", 26),
                new Person("Amitosh", "Mishra", 30),
                new Person("Aswini", "Baliarsingh", 31),
                new Person("Surya", "Menon", 29),
                new Person("Akash", "Hinger", 29));


        Stream<Integer> nameLengthStream = people.stream()
                .map(person -> person.getFirstName().length());

        nameLengthStream.forEach(obj -> System.out.print(obj + " "));

    }
}

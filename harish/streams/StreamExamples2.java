package practice.harish.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples2 {

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

        numbers.stream()
                .map(integer -> integer*integer)
                .forEach(x -> System.out.print(x + " "));

        System.out.println("Showing names starting with S");

        List filteredNames = names.stream()
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toList());

        System.out.println(filteredNames);

        List sortedNames = names.stream()
                                .sorted()
                                .collect(Collectors.toList());

        System.out.println("Showing names sorted");
        System.out.println(sortedNames);

        sortedNames = names.stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .collect(Collectors.toList());

        System.out.println("Showing names sorted in reverse");
        System.out.println(sortedNames);

        Set<Integer> squareSet = numbers.stream()
                .map(a -> a * a)
                .collect(Collectors.toSet());

        System.out.println(squareSet);
        System.out.println();

        System.out.println("Using reduce method of Java8 streams");
        numbers.stream()
                .reduce((integer, integer2) -> integer + integer2)
                .ifPresent(integer -> System.out.println("Sum of all elements in array : " + integer ));

        // Find the person with maximum age

        Optional<Person> maxAgePerson = people.stream()
                .reduce((person1, person2) -> person1.getAge() > person2.getAge() ? person1 : person2);

        System.out.println(maxAgePerson.get().getFirstName() + "'s age is highest : " + maxAgePerson.get().getAge());

        Stream.generate(Math::random)
                .limit(5)
                .map(x-> Math.round(x*12.0))
                .forEach(System.out::println);

        Stream.iterate(2, integer -> integer +2).limit(10).forEach(x->System.out.print(x + " "));



    }
}

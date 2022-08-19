package harish.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamWithGrouping {
    public static void main(String[] args) {
       Person person1 = new Person("Harish0", "Lalwani", 33);
       Person person2 = new Person("Harish1", "Lalwani", 34);
       Person person3 = new Person("Harish2", "Lalwani", 33);
       Person person4 = new Person("Harish3", "Lalwani", 34);
       Person person5 = new Person("Harish4", "Lalwani", 37);

       List<Person> personList = new ArrayList<>();
       personList.add(person1);
       personList.add(person2);
       personList.add(person3);
       personList.add(person4);
       personList.add(person5);

        Map<Integer, List<Person>> groupByAge = personList.stream().
                collect(Collectors.groupingBy(person -> person.getAge()));
//        System.out.println(groupByAge);

        // Grouping by age and then further reducing the objects to just the set of names
        Map<Integer, Set<String>> groupByAgeToSet = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getFirstName, Collectors.toSet())));
//        System.out.println(groupByAgeToSet);

        Map<Integer, Set<String>> groupByAgeToSet1 = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge, TreeMap::new,
                        Collectors.mapping(Person::getFirstName, Collectors.toSet())));

        int[] numbers = {1,2,3,4,5,6,7,8,9,11,12,13};
        String[] colors = {"RED", "GREEN", "BLUE", "YELLOW", "CYAN", "MAGENTA", "PURPLE"};
//        List<String> colorList = Arrays.asList(colors);
//        colorList.add("PURPLE");
//        System.out.println(colorList);

        String name  = "Harisdklfsadkfjaf;ldsvsmnvbadw;iofewsh";
        List<String> characterList = Arrays.asList(name.split(""));
        Map<Object, Long> characterLongMap = characterList.stream()
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()));
//        System.out.println(characterLongMap);

        List<String> colorList = new ArrayList<>();
        boolean b = Collections.addAll(colorList, colors);
        System.out.println(colorList);


    }
}

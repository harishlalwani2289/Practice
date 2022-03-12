package harish.hashmappractice;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Person, Integer> experienceMap = new HashMap<>();

        experienceMap.put(new Person("Tanya", 20), 3);
        experienceMap.put(new Person("Shubham", 34), 9);
        experienceMap.put(new Person("Siddhesh", 24), 1);

        System.out.println(experienceMap.get(new Person("Tanya", 20)));

    }

}

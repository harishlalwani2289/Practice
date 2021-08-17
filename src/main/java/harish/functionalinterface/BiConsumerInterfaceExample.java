package harish.functionalinterface;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerInterfaceExample {

    static void showDetails(String name, Integer age) {
        System.out.println("Name :" + name + " age : " + age);
    }

    static void showMapDetails(Map<Integer, String> map, String mapName){
        System.out.println("----------"+mapName+" records-----------");
        map.forEach((key, val)->System.out.println(key+" "+val));
    }

    public static void main(String[] args) {
        // referring method
        BiConsumer<String, Integer> biConsumer = BiConsumerInterfaceExample::showDetails;
        biConsumer.accept("Ramya", 20);
        biConsumer.accept("Ram", 24);

        BiConsumer<String, Integer> biConsumer1 = (name, age) -> System.out.println("Name :" + name + " age : " + age);
        biConsumer1.accept("Harish", 32);

        Map<Integer, String> map = new HashMap<Integer,String>();
        map.put(100, "Mohan");
        map.put(110, "Sujeet");
        map.put(115, "Tom");
        map.put(120, "Danish");

        BiConsumer<Map<Integer,String>, String> biConsumer2 = BiConsumerInterfaceExample::showMapDetails;
        biConsumer2.accept(map, "Student");

        //BiConsumer andThen Example

        BiConsumer<Integer, Double> bc = (i, d) -> System.out.printf("integer: %s, double: %s%n", i, d);
        BiConsumer<Integer, Double> bc2  = (i,d) -> {
            BigDecimal sumInBigDecimal = BigDecimal.valueOf(d).add(BigDecimal.valueOf(i)).setScale(2, RoundingMode.CEILING);
            System.out.println("sum: " + sumInBigDecimal);
        };

        Map.of(1,3.33d, 2, 4.999d, 3, 5.889d).forEach(bc.andThen(bc2));
    }
}

package harish.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(9);
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);

        System.out.println(numbers.stream().mapToDouble(value -> value + 0.1).boxed()
            .collect(Collectors.toList()));

    }
}

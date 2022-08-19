package leetcode.dailychallenges;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReduceArraySizeToHalf {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(minSetSize(arr));
    }
    public static int minSetSize(int[] arr) {

        Set<Integer> result = new HashSet<>();

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i : arr) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        LinkedHashMap<Integer, Integer> sortedByFrequency = frequencyMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println(sortedByFrequency);

        int size = 0;
        for(Map.Entry entry : sortedByFrequency.entrySet()) {
            size = size + (int)entry.getValue();
            result.add((Integer)entry.getKey());
            if(size >=  arr.length/2)
                break;
        }
        return result.size();
    }
}

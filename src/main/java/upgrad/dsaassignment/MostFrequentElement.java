package upgrad.dsaassignment;

import java.util.HashMap;

public class MostFrequentElement {

    public static void main(String[] args) {
        int[] input = {2, 3, 3, 2, 1, 1, 2, 4, 5, 6};
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Storing the frequencies
        for(int i : input) {
            if(countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }

        // for finding the key with maximum value
        // Finding the number with maximum frequency
        int maxCount = 0;
        int res = Integer.MAX_VALUE;
        for(Integer key : countMap.keySet()) {
            if(countMap.get(key) > maxCount) {
                maxCount = countMap.get(key);
                res = key;
            }
        }

        System.out.println("Maximum frequency element is  " + res);


    }
}

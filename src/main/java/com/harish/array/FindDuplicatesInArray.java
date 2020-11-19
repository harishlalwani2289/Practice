package com.harish.array;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesInArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,3,6,6};

        HashMap<Integer,Integer> arrMap = new HashMap<>();

        for(int i: arr) {
            if(arrMap.containsKey(i)) {
                arrMap.put(i, arrMap.get(i) +1);
            }
            else {
                arrMap.put(i,1);
            }
        }

        for (Map.Entry entry : arrMap.entrySet()) {
            if((int)entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }

    }
}

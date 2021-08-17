package harish.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortArrayWithRecursion {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(7);
        arr.add(6);
        arr.add(4);
        arr.add(9);
        arr.add(5);
        sort2(arr, arr.size());

        for(Integer i : arr) {
            System.out.println(i);
        }
    }

    private static void sort(List<Integer> arr) {

        if(arr.size() ==1)
            return;

        int temp = arr.get(arr.size() - 1);
        arr.remove(arr.size()-1);
        sort(arr);
        InsertInSortedArray.insert((ArrayList<Integer>) arr, arr.size(), temp);
    }

    private static void sort2(List<Integer> arr, int length) {
        if(length ==1)
            return;

        // Find the index of max element in array
        int maxIndex = arr.indexOf(Collections.max(arr.subList(0, length)));

        int temp = arr.get(maxIndex);
        arr.set(maxIndex, arr.get(length -1));
        arr.set(length-1, temp);

        sort2(arr, length-1);

    }
}

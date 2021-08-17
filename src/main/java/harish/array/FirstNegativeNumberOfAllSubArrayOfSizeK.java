package harish.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNegativeNumberOfAllSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {11,12,-14,-7,9,-4,-15,12,-90,13};
        int k = 3;
        findFirstNegativeNumberOnSubArraysOFSizeK(arr, k);
    }

    private static void findFirstNegativeNumberOnSubArraysOFSizeK(int[] arr, int k) {
        // Deque will store the useful elements
        Deque<Integer> deque = new ArrayDeque<>();
        int n = arr.length;
        int i = 0;
        for(i=0;i<k;i++) {
            if(arr[i] < 0) {
                deque.addLast(i);
            }
        }

        for(;i<n;i++) {
            System.out.println(arr[deque.peekFirst()] + " ");

            // We have to remove the elements
            // which are out of the current window
            while(!deque.isEmpty() && deque.peekFirst() <= (i-k))
                deque.removeFirst();

            if(arr[i] < 0) {
                deque.addLast(i);
            }
        }

        System.out.println(arr[deque.peekFirst()] + " ");

    }
}

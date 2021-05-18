package practice.harish.array;

// question here is to find the maximum of exh subarray of size given k
// Lets see example
// Lets say k = 4... so fisrt four element's maximum of following array
// {8,5,10,7,9,4,15,12,90,13} is 10
// Next four elements are 5,10,7,9, here also maximum is 10

// Video Explanation : https://www.youtube.com/watch?v=39grPZtywyQ
import java.util.ArrayDeque;
import java.util.Deque;

// BruteForce method would be to find the maximum from all subarrays of length k
// But we will go for optimum solution lets see
public class MaximumOfAllSubArraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = {11,12,14,7,9,4,15,12,90,13};
        findMaximumOfAllSubArraysOfSizeK(arr,5);
    }

    private static void findMaximumOfAllSubArraysOfSizeK(int[] arr, int k) {
        int n = arr.length;

        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi =  new ArrayDeque<>();
        int i;
        for (i = 0; i < k; ++i)
        {

            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >=
                    arr[Qi.peekLast()])

                // Remove from rear
                Qi.removeLast();

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        for(;i<n;i++) {
            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which
            // are out of this window
            while(!Qi.isEmpty() && Qi.peek() <= i-k) {
                Qi.removeFirst();
            }

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
            }
            Qi.addLast(i);
        }
        System.out.print(arr[Qi.peek()] + " ");
    }
}

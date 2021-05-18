package practice.harish.array;

import java.util.Arrays;

public class ConsecutiveNumbersWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,9,10,3,8,5,7};
        Arrays.sort(arr);
        findConsecutiveNumbersWithSum(arr,11);
    }

    private static void findConsecutiveNumbersWithSum(int[] arr, int k) {

        int start = 0;
        int end = 0;
        boolean found = false;
        int sum = arr[start];
        while(found == false) {
            if(sum < k) {
                end = end+1;
                sum += arr[end];
            }
            else if (sum > k) {
                sum -= arr[start];
                start = start+1;
            }
            else {
                found = true;
            }
        }

        for (int i= start; i<=end;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

package harish.array;

import java.util.HashMap;

public class FindPairWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,-1,-5,-1,-2};
        findPairsWithSum(arr, 6);
    }

    private static void findPairsWithSum(int[] arr, int k) {
        HashMap<Integer,Integer> arrMap = new HashMap<>();

        // First we store all the elements in a HashMap
        for(int i : arr) {
            if(!arrMap.containsKey(i)) {
                arrMap.put(i,0);
            }
            arrMap.put(i,arrMap.get(i) + 1);
        }

        System.out.println(arrMap);

        int count = 0;

        for(int i=0;i<arr.length;i++) {

            if(arrMap.containsKey(k-arr[i])) {
                count = count + arrMap.get(k-arr[i]);
                System.out.println(arr[i] + " " + (k-arr[i]));
            }
        }
        // We are printing half of the count because every pair is counted twice.
        System.out.println(count/2);
    }
}

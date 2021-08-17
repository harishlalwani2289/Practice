package harish.array;

import java.util.HashSet;
import java.util.Set;

public class FindLongestConsequentSubSequenceLength {

    public static void main(String[] args) {
        int[]  arr = {1,13,5,6,8,9,2,3};
        System.out.println(findLongestConsequentSubSequenceLength(arr));

    }

    private static int findLongestConsequentSubSequenceLength(int[] arr) {
        int ans =0;

        // First let put all the elements in set.
        Set<Integer> numberSet = new HashSet<>();
        for(int i : arr) {
            numberSet.add(i);
        }
        // Now that the numbers have been added to set
        // We will go one by one and find the longest subsequence for any number

        for(int i=0;i<arr.length;i++) {
            int count = 0;
            if(!numberSet.contains(arr[i] -1)){
                int j= arr[i];
                while(numberSet.contains(j)) {
                    count++;
                    j++;
                }
            }
            ans  = Math.max(ans,count);
        }
        return ans;
    }
}

package com.harish.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {10,9,22,33,14,50,60};
        // First we will create our new array with all the value intialized to 1 of same length as above array
        int lis[] = new int[arr.length];

        // Inititalize all the elements of lis array to 1
        // As an element itelf is of length 1 of longest increasing subsequence
        Arrays.fill(lis,1);

        System.out.println(getLongestSubsequence(arr,lis).get());
     }

    private static Optional<Integer> getLongestSubsequence(int[] arr, int[] lis) {
        for (int i = 1; i < arr.length; i++) {
            for(int j=0;j<i;j++) {
                if(arr[i] > arr[j]) {
                   lis[i] =  lis[j] + 1 > lis[i] ? lis[j] +1 : lis[i];
                }
            }
        }

        List<Integer> lisOutputList = Arrays.stream(lis).boxed().collect(Collectors.toList());
        return  lisOutputList.stream().max(Comparator.naturalOrder());
    }
}
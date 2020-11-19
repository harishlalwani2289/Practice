package com.harish.dynamicprogramming;

/*
In edit distance we find what is the minimum number of operation required to convert string1 to string2
Operations are:
    Replace
    Insert
    Delete
For example we have two string cats and pits.
For this we require minimum of two operations to convert cats to pits
            ----> Replacing ca with pi

 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "CAT";
        String s2 = "CAT";

        int minimumOperation = findMinimumDistance(s1,s2);
        System.out.println("Minimum number of operations required is :" + minimumOperation);
    }

    public static int findMinimumDistance(String s1, String s2) {

        // We need an array of size s1.length +1 and s2.length+1 or vice versa to complete this
        // We are solving this dynamically because we want to store the sub problems solution

        int[][] editDistance = new int[s1.length()][s2.length()];

        // We will go row by row and check what it takes to operation on first single letter, than two letters combine and so on

        for (int i = 0; i < s1.length() ; i ++) {
            for(int j = 0; j < s2.length() ; j++) {
                if(i == 0) {
                    editDistance[i][j] = j;
                }
                else if ( j == 0) {
                    editDistance[i][j] = i;
                }
                else {
                    if(s1.charAt(i-1) == s2.charAt(j-1)) {
                        editDistance[i][j] = findMinOf(editDistance[i][j-1],editDistance[i-1][j-1],editDistance[i-1][j]);
                    }
                    else
                        editDistance[i][j] = findMinOf(editDistance[i][j-1],editDistance[i-1][j-1],editDistance[i-1][j]) + 1;
                }
            }
        }
        return editDistance[s1.length()-1][s2.length()-1];
    }

    private static int findMinOf(int num1, int num2, int num3) {
        List<Integer> numberList = Arrays.asList(num1,num2,num3);
        Optional<Integer> number = numberList.stream().min(Comparator.naturalOrder());
        return number.orElse(-1);
    }
}

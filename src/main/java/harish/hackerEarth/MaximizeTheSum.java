package harish.hackerEarth;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * You are given an array  of  integers. You want to choose some integers from the array subject to the condition that the number of distinct integers chosen should not exceed . Your task is to maximize the sum of chosen numbers.
 *
 * You are given  test cases.
 *
 * Input format
 *
 * The first line contains a single integer  denoting the number of test cases.
 * The first line of each test case contains two space-separated integers  and  denoting the length of the array and the maximum number of distinct integers you can choose.
 * The second line of each test case contains  space-separated integers denoting the integer array .
 * Output format
 *
 * For each test case(in a separate line), print the maximum sum you can obtain by choosing some elements such that the number of distinct integers chosen is at most . If you cannot choose any element, output .
 *
 * Constraints
 *
 * Sample Input
 * 2
 * 4 1
 * 3 -1 2 5
 * 4 2
 * 2 1 2 5
 * Sample Output
 * 5
 * 9
 * Time Limit: 1.5
 * Memory Limit: 256
 * Source Limit:
 * Explanation
 * In the first test case, we have , . Since we can choose at most 1 distinct integer, we choose . The sum is also  and we output it.
 *
 * In the second test case, we have , . We need to choose at most 2 distinct integers, we choose . Note that the condition is choosing atmost  distinct integers. So we can choose repeated number as many times as we want. The sum is  and we output it.
 */
public class MaximizeTheSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        int lengthOfArray = scanner.nextInt();
        int distinctIntegerToChose = scanner.nextInt();
        List<Integer> numberList = new ArrayList<>(lengthOfArray);

        for (int i =0; i< lengthOfArray;i++) {
            numberList.add(scanner.nextInt());
        }

        // We have taken the input, next step is to store the number of occurences of these input in some Map.
        
    }
}

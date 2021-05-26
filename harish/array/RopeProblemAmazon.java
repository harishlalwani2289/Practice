package practice.harish.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to the sum of their lengths. We need to connect the ropes with minimum cost.
 * For example, if we are given 4 ropes of lengths 4, 3, 2, and 6. We can connect the ropes in the following ways.
 * 1) First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5.
 * 2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 * 3) Finally connect the two ropes and all ropes have connected.
 * Total cost for connecting all ropes is 5 + 9 + 15 = 29.
 *  This is the optimized cost for connecting ropes.
 *  Other ways of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first (we get three strings of 3, 2 and 10),
 *  then connect 10 and 3 (we get two strings of 13 and 2).
 *  Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
 */

public class RopeProblemAmazon {


    public static void main(String[] args) {
        //List<Integer> ropeLengths = Arrays.asList(1,3,5,6,7,9);
        ArrayList<Integer> ropeLengths = new ArrayList<>(Arrays.asList(1,3,5));
        int totalCost = 0;

        while(ropeLengths.size() > 2) {
            // First step is to find the smallest two numbers in an array
            List<Integer> twoSmallestNumber = TwoSmallestNumber.findTwoSmallestNumber(ropeLengths.stream().mapToInt(i -> i).toArray());

            // Add the two smallest numbers and remove the individual elements from array
            totalCost = totalCost + twoSmallestNumber.get(0).intValue() + twoSmallestNumber.get(1).intValue();
            ropeLengths.add((twoSmallestNumber.get(0).intValue() + twoSmallestNumber.get(1).intValue()));
            ropeLengths.remove(Integer.valueOf(twoSmallestNumber.get(0).intValue()));
            ropeLengths.remove(Integer.valueOf(twoSmallestNumber.get(1).intValue()));
        }
        System.out.println(ropeLengths.stream().reduce(0, (a,b) -> a+b) + totalCost);

    }
}

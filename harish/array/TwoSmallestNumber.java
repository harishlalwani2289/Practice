package practice.harish.array;

import java.util.Arrays;
import java.util.List;

public class TwoSmallestNumber {

    public static void main(String[] args) {
        int[] number = {12,8,5,3,9,11};
        findTwoSmallestNumber(number);
    }

    public static List<Integer> findTwoSmallestNumber(int[] number) {
        int first  = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i = 0; i< number.length; i++) {

            if (number[i] < first) {
                second = first;
                first = number[i];
            }
            else if (number[i] < second) {
                second = number[i];
            }
        }
        List<Integer> smallestNumbers  = Arrays.asList(first,second);
        return smallestNumbers;
    }
}

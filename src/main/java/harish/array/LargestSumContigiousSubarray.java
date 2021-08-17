package harish.array;

/**
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
 * Kadane's Algorithm
 */
public class LargestSumContigiousSubarray {

    public static void main(String[] args) {
        int[] numbers = {-2,2,5,-11,6,2};

        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0, end =0, start = 0, s=0;

        for(int i=0; i< numbers.length; i ++) {

            maxEndingHere = maxEndingHere + numbers[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end =i;
            }
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i+1;
            }
        }
        System.out.println(maxSoFar);
        System.out.println(start);
        System.out.println(end);


    }
}

package harish.dynamicprogramming;
/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 For example, if length of the rod is 8 and the values of different pieces are given as following,
 then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
 */
public class RodCuttingProblem {

    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                cutRod(arr, size));
    }

    private static int cutRod(int[] arr, int size) {
        int val[] = new int[size+1];
        val[0] = 0;

        for(int i=1;i<=size;i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j=0;j<i;j++) {
                maxValue = Math.max(maxValue, arr[j] + val[i-(j+1)]);
            }
            val[i] = maxValue;
        }
        return val[size];
    }
}

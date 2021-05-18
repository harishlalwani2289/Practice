package practice.harish.dynamicprogramming;

import java.util.Arrays;

/*
Given a value N, if we want to make change for N cents,
 and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
So the output should be 5.
 */
public class CoinChangeProblem {

    public static void main(String[] args) {
        int[] coins = {1,2};
        int m = coins.length; //Number of coins
        int n = 3; // We want to know the number of ways to make this much amount using above coins
        //System.out.println(countWays(coins,m,n));
        System.out.println(countWays2(coins,m,n));
    }

    private static int countWays2(int[] coins, int m, int n) {

        if(n<0)
            return 0;
        if(n == 0)
            return 1;
        if(m<=0 && n>0)
            return 0;

        return countWays2(coins, m, n-coins[m-1]) + countWays2(coins, m-1, n);
    }

    public static int countWays(int[] coins, int m, int n) {

        //  We will have to create an array with n+1 values
        int[] result = new int[n+1];
        Arrays.fill(result,0);

        result[0] =1; // There is one way to make zero. Do not take any coins

        for(int i=0;i<m;i++) {
            for(int j=1;j<=n;j++) {
                if (coins[i] <= j) {
                    result[j] = result[j] + result[j-coins[i]];
                }
            }
        }

        return result[n];
    }
}

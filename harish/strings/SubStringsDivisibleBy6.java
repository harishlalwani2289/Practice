package string;

import java.util.*;
public class SubStringsDivisibleBy6{
    static int result = 0;
    public static int helper(int i, int rem, char[] str, int[][] dp)
    {
        if(i == str.length)
            return 0;
        if(dp[i][rem] != -1)
            return dp[i][rem];
        int x = str[i] - '0';
        if(x % 2 == 0 && (x + rem) % 3 == 0)
        {
            result = 1 + helper(i + 1, (x + rem) % 3, str, dp);
        }
        else
        {
            result = helper(i + 1, (x + rem) % 3, str, dp);
        }
        dp[i][rem] = result;
        return dp[i][rem];
    }
    public static int countSubStrings(char[] str)
    {
        int n = str.length;
        int count = 0;

        // for storing the values
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                dp[i][j] = -1; // initialize all values to -1
            }
        }
        for(int i = 0; i < str.length; i++)
        {
            if(str[i] - '0' == 0)
            {
                count++;
            }
            else
            {
                count = count + helper(i, 0, str, dp);
            }
        }
        return count;
    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] str = s.toCharArray();
        int ans = countSubStrings(str);
        System.out.println(ans);
    }
}
package harish.dynamicprogramming;

public class ClimbStairs {

  public static void main(String[] args) {
    int n = 13;
    System.out.println(countPaths(n));
  }

  private static int countPaths(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = dp[0] + dp[1];

    for (int i = 3; i < n + 1; i++) {
        dp[i] = dp[i-1] + dp[i-2] + dp [i-3];
    }
    return dp[n];
  }

}

package upgrad;

public class MinimumCostPath {

  public static void main(String[] args) {
    int[][] arr = new int[6][8];

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 8; j++) {
        arr[i][j] = (int) (Math.random() * 10);
      }
    }

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 8; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

    findMinimumCost(arr);
  }

  private static void findMinimumCost(int[][] arr) {

    int n = arr.length;
    int m = arr[0].length;
    int[][] dp = new int[n][m];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (i == n - 1 && j == m - 1) {
            dp[i][j] = arr[i][j];
        } else if ( i == n-1) {
          dp[i][j] = dp[i][j+1] + arr[i][j];
        } else if (j == m-1) {
          dp[i][j] = dp[i+1][j] + arr[i][j];
        } else {
          dp[i][j] = arr[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
        }
      }
    }

    System.out.println(dp[0][0]);
  }

}

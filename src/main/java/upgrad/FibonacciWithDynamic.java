package upgrad;

public class FibonacciWithDynamic {

  public static void main(String[] args) {

    System.out.println(fib(10, new int[11]));

  }

  private static int fib(int n, int[] ans) {
    if (n <= 1) {
      return n;
    }

    if(ans[n] != 0) {
      return ans[n];
    }
    System.out.println("Hello " + n);
    int fibnm1 = fib(n - 1, ans);
    int fibnm2 = fib(n - 2, ans);
    ans[n] = fibnm1 + fibnm2;
    return fibnm1 + fibnm2;


  }
}

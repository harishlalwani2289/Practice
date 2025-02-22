package pepcoding.recursion_backtracking;

public class XPowerN {

    public static void main(String[] args) {
        System.out.println(power(2, 5));
        System.out.println(power_logarithmic(2, 5));
    }

    private static int power_logarithmic(int x, int n) {
        if (n == 1)
            return x;
        return n % 2 == 0 ?
                power_logarithmic(x, n / 2) * power_logarithmic(x, n / 2)
                : x * power_logarithmic(x, n / 2) * power_logarithmic(x, n / 2);
    }

    public static int power(int x, int n) {
        if (n == 0)
            return 1;
        return x * power(x, n - 1);
    }

}

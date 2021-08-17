package harish.random;

public class UpgradFibonacci {
    public static void main(String[] args) {

        System.out.println((printFibonacci(5)));
    }

    private static long printFibonacci(long i) {

        if(i == 1 || i == 2) {
            return 1;
        }
        long next = printFibonacci(i -2) + printFibonacci(i - 1);
        System.out.println(next);
        return next;
    }
}

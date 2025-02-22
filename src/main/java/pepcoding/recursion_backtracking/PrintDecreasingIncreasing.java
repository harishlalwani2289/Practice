package pepcoding.recursion_backtracking;

public class PrintDecreasingIncreasing {

    public static void main(String[] args) {
        printDecreasingIncreasing(12);
    }

    public static void printDecreasingIncreasing(int n) {
        if( n == 0)
            return;
        System.out.println(n);
        printDecreasingIncreasing(n-1);
        System.out.println(n);
    }
}

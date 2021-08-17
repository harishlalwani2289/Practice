package harish.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.*;

public class Accolite2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Declare the variable
        int a;

        // Read the variable from STDIN
        a = in.nextInt();
        int[] tests = new int[a];

        // Input the number of test
        for(int i=0;i<a;i++) {
            tests[i] = in.nextInt();
            // Now for each test we have to find the number of ways
            long noOfTwos = tests[i]/2l;
            long noOfOnes = 0l;
            long totalWays = 0l;
            for(long j=0l;j<=noOfTwos;j++) {
                noOfOnes = tests[i] - (j*2);
                totalWays = totalWays + (factorial(noOfOnes + j)/(factorial(noOfOnes) * factorial(j)));
            }
            System.out.println(totalWays);
        }
    }

    private static long factorial(long number) {
        long fact = 1l;
        if(number <= 1) {
            return 1;
        }
        for(long i=2;i<=number;i++){
            fact = fact*i;
        }
        return fact;
    }
}

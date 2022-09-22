package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReorderedPowerof2 {
    public static void main(String[] args) {
        int n = 132340;
        System.out.println(reorderedPowerOf2(n));
    }

    public static  boolean reorderedPowerOf2(int n) {

        List<Integer> digits = new ArrayList<>();

        while (n > 0) {
            int temp = n%10;
            digits.add(temp);
            n = n/10;
        }
        System.out.println(digits.toString());

        return false;
    }
}

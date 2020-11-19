package random;

import java.math.BigInteger;

public class BigIntegerPractice {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("111233442394723477");
        System.out.println(bigInteger.add(bigInteger));
        int a= 344;
        BigInteger bigInteger1 = BigInteger.valueOf(a);
        System.out.println(bigInteger.add(bigInteger1));
        System.out.println(bigInteger.doubleValue());


    }
}

package random;

public class BinaryStringToDecimal {

    static long FindBigNum(long n) {
        String binaryString = "";
        long sum = 0;
        for (int i=1;i<=n;i++) {
            binaryString = binaryString + findBinaryString(i);
        }
        int pow =0;
        // We have got the binary string now we have to calculate the number
        int j;
        for (j=binaryString.length()-1,pow=0; j>=0 && pow<=binaryString.length()-1; j--,pow++) {
            long temp = Integer.parseInt(String.valueOf(binaryString.charAt(j)));
            sum  = (long) (sum + temp*(Math.pow(2.0,pow)));
        }
        System.out.println(sum);
        return sum;
    }

    static String findBinaryString(long number) {
        StringBuilder binaryString = new StringBuilder();
        while(number != 0) {
            if (number%2 == 0) {
                binaryString.append("0");
            }
            else{
                binaryString.append("1");
            }
            number/=2;
        }
        return binaryString.reverse().toString();
    }

    public static void main(String[] args) {
        FindBigNum(3);
    }
}

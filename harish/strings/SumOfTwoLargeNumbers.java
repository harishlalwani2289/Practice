package practice.harish.strings;

public class SumOfTwoLargeNumbers {
    public static void main(String[] args) {
        String number1 = "12";
        String number2 = "198111";
        System.out.println(findSum(number1, number2));
    }

    private static String findSum(String number1, String number2) {
        // Lets always make the length of number 2 highest
        if(number1.length() > number2.length()) {
            String t = number1;
            number1 = number2;
            number2 = t;
        }

        int n1 = number1.length();
        int n2 = number2.length();

        // Revrse both the string
        number1 =  new StringBuilder(number1).reverse().toString();
        number2 = new StringBuilder(number2).reverse().toString();


        String result = "";
        int carry = 0;

        for(int i=0;i<n1;i++) {
            int sum = (int)(number1.charAt(i) - '0') + (int)(number2.charAt(i) - '0') +carry;
            result += (char)(sum%10 + '0');
            carry = sum/10;
        }

        for(int i=n1;i<n2;i++) {
            int sum = (int)((number2.charAt(i)) - '0') + carry;
            result += (char)(sum%10 + '0');
            carry = sum/10;
        }

        if(carry > 0) {
            result += (char)(carry + '0');
        }

        result = new StringBuilder(result).reverse().toString();

        return result;
    }
}

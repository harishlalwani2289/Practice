package string;

/**
 Given a string of numbers, the task is to find the maximum value from the string, you can add a ‘+’ or ‘*’ sign between any two numbers.

 Examples:

 Input : 01231
 Output :
 ((((0 + 1) + 2) * 3) + 1) = 10
 In above manner, we get the maximum value i.e. 10

 Input : 891
 Output :73
 As 8*9*1 = 72 and 8*9+1 = 73.So, 73 is maximum.

 https://www.geeksforgeeks.org/calculate-maximum-value-using-sign-two-numbers-string/
 **/
public class Problem1 {
    public static void main(String[] args) {
        String input  = "00100501010";
        solve(input);
    }

    private static void solve(String input) {
        int result = input.charAt(0) - '0';
        for(int i=1;i<input.length();i++) {
            if(input.charAt(i) - '0' <= 1 || result < 2) {
               result = result + (input.charAt(i) - '0');
            }
            else {
               result = result * (input.charAt(i) - '0');
            }
        }
        System.out.println(result);
    }
}

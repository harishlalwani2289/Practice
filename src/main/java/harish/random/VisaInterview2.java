package harish.random;

/**
 * [11:20 AM] Idupulapati, Alekhya
 * Given two strings, find if first string is a subsequence of secondGiven two strings str1 and str2,
 * find if str1 is a subsequence of str2. A subsequence is a sequence that can be derived from another sequence by
 * deleting some elements without changing the order of the remaining elements 
 * Examples : Input: str1 = "AXY", str2 = "ADXCPY"Output: True (str1 is a subsequence of str2)
 * Input: str1 = "AXY", str2 = "YADXCP"Output: False (str1 is not a subsequence of str2)
 * Input: str1 = "gksrek", str2 = "geeksforgeeks"Output: True (str1 is a subsequence of str2)
 */
public class VisaInterview2 {
    public static void main(String[] args) {
        String source = "ADXCPY";
        String checkString = "YXA";

        int lengthOfCheckString = checkString.length();
        int visited =0;
        for(int i=0;i<source.length();i++) {
            if(checkString.charAt(visited) == source.charAt(i)) {
                visited++;
            }
            if(visited == lengthOfCheckString) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }
}

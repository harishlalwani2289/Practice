package harish.strings;

import harish.strings.StringUtil;

/**
 * Given a string of digits, determine whether it is a ‘sum-string’.
 * A string S is called a sum-string if a rightmost substring can be written as sum
 * of two substrings before it and same is recursively true for substrings before it.
 * <p>
 * Examples :
 * <p>
 * “12243660” is a sum string.
 * Explanation : 24 + 36 = 60, 12 + 24 = 36
 * <p>
 * “1111112223” is a sum string.
 * Explanation: 111+112 = 223, 1+111 = 112
 * <p>
 * “2368” is not a sum string
 * In general a string S is called sum-string if it satisfies the following properties:
 * <p>
 * sub-string(i, x) + sub-string(x+1, j)
 * = sub-string(j+1, l)
 * and
 * sub-string(x+1, j)+sub-string(j+1, l)
 * = sub-string(l+1, m)
 * and so on till end.
 */
public class CheckSumString {
    public static void main(String[] args) {
        String input = "5560115175290465";
        int n = input.length();
        for(int i=1;i<n;i++){
            for(int j=1;i+j<n;j++){
                if(checkSumString(input,0,i,j)) {
                    System.out.println("Given String is Sum String");
                    return;
                }
            }
        }
        System.out.println("Given String is not a sum string");
    }

    public static boolean checkSumString(String input, int begin, int len1, int len2) {

        String subString1 = input.substring(begin,begin+len1);
        String subString2 = input.substring(begin+len1, begin +len1 + len2);
        String subString3 = StringUtil.addTwoStringsArithmetically(subString1,subString2);

        // Now that we have the result subString
        // This substring should be inside the input string
        // If not we should return false
        if( subString3.length() > input.length()-len1-len2-begin)
            return false;

        // Now we check this substring with the input string next substring
        // of length same as of subString3
        if(subString3.equals(input.substring(begin+len1+len2,begin+len1+len2+subString3.length()))) {
            // Now we know that our sub string is present
            // Next check if we have reahced the end of string
            // If yes the input string is Sum String
            if(input.length() == begin+len1+len2+subString3.length())
                return true;
            // Else we have to check for next set of subStrings
            // Calling recursively the next set
            else
                return checkSumString(input,begin+len1,len2,subString3.length());
        }
        return false;
    }
}

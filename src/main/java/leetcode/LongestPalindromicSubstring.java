package leetcode;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String sample = "atesbccbsetc";
        System.out.println(longestPalindrome(sample));
    }

    public static String longestPalindrome(String s) {

        // We will prepare a DP matrix of size s.length * s.length
        // Rows will be the start point
        // Columns will be the end point
        // Each entry in this matrix will represent whether the substring starting from i
        // to j is palindrome or not
        boolean[][] dp = new boolean[ s.length()][s.length()];

        // Here g represents the gap
        // Gap means we are travelling through diagonal and lower diagonal is not applicable as
        // the value of i will be greater than value of j which is not possible
        int len = 0;
        int start = 0;
        int end = 0;
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); j++, i++) {
                if (gap == 0) {
                    // All the single character substring are always palindrome
                    dp[i][j] = true;
                } else if (gap == 1) {
                    // For gap = 1 that means 2 character string
                    // Both should be same to be palindrome
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    // Every other case we will check if start and end character are same and
                    // middle part should be palindrome
                    // Middle part will be when we move start one step ahead and end one step behind
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j]) {
                    len = gap + 1;
                    start = i;
                    end = j;
                }
            }
        }


        return s.substring(start,end+1);
    }
}

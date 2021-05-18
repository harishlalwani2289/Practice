package practice.harish.dynamicprogramming;


public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int[][]  lcs  = new int[s2.length()+1][s1.length()+1];

        int lengthOfLCS = getLongestCommonSubsequence(s1,s2,lcs);
        printLCS2DArray(lcs);
        System.out.println();
        printLongestCommonSubsequence(s1, s2, lcs);
    }

    private static void printLongestCommonSubsequence(String s1, String s2, int[][] lcs) {
        String longestCommonSubsequence = "";

        int i = lcs.length -1;
        int j = lcs[0].length -1;
        System.out.println(i);
        System.out.println(j);

        while(i>0 && j>0) {
            if(lcs[i][j] == lcs[i-1][j])
                i--;
            else if (lcs[i][j] == lcs[i][j-1])
                j--;
            else if(lcs[i-1][j-1] + 1 == lcs[i][j]) {
                longestCommonSubsequence += s2.charAt(i - 1);
                i--; j--;
            }
        }

        System.out.println(reverseTheString(longestCommonSubsequence));

    }

    private static String reverseTheString(String longestCommonSubsequence) {
        String reversedString = "";
        for(int i = longestCommonSubsequence.length() -1;i>=0;i--) {
            reversedString += longestCommonSubsequence.charAt(i);
        }
        return  reversedString;
    }

    private static void printLCS2DArray(int[][] lcs) {
        for(int i=0;i<lcs.length;i++) {
            System.out.println();
            for(int j=0;j<lcs[i].length;j++) {
                System.out.print(lcs[i][j] + "  ");
            }
        }
    }

    private static int getLongestCommonSubsequence(String s1, String s2, int[][] lcs) {
        // We know that empty string against empty string has no common subsequence
        // so we will not change the value of first row of array and value of first clolumn
        // We will keep them 0

        for (int i = 1; i <= s2.length(); i++) {

            for (int j = 1; j <= s1.length(); j++) {
                if(s2.charAt(i-1) == s1.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] +1;
                }
                else {
                    lcs[i][j] = lcs[i-1][j] > lcs[i][j-1] ? lcs[i-1][j] : lcs[i][j-1];
                }
            }
        }
        return lcs[s2.length()][s1.length()];
    }
}

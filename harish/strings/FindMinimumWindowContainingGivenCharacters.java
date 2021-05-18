package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings string1 and string2, the task is to find the smallest substring in string1
 * containing all characters of string2 efficiently.
 *
 * Examples:
 *
 * Input: string = “this is a test string”, pattern = “tist”
 * Output: Minimum window is “t stri”
 * Explanation: “t stri” contains all the characters of pattern.
 *
 * Input: string = “geeksforgeeks”, pattern = “ork”
 * Output: Minimum window is “ksfor”
 */
public class FindMinimumWindowContainingGivenCharacters {
    public static void main(String[] args) {
        String source = "this is the test string";
        String target = "tist";
        String resultSubString  = findMinimumWindowContaining(source,target);
        System.out.println(resultSubString);
    }

    public static String findMinimumWindowContaining(String source, String target) {

        // Store each character of target string in a Map
        Map<Character,Integer> targetMap = new HashMap<>();
        for(Character c : target.toCharArray()) {
            if(!targetMap.containsKey(c)) {
                targetMap.put(c,0);
            }
            targetMap.put(c, targetMap.get(c) + 1);
        }
        // First we have to find the first window containing all the characters
        // Initializing the window moving variable to start of the string
        int l=0,r=0;

        // Here required and formed is used to get
        // the required distinct characters to be formed in minimum window
        int required = targetMap.size();
        int formed = 0;


        // Store the counts of each character in current window
        Map<Character,Integer> windowCounts = new HashMap<>();

        // Here ans array store the length of subsring -- used to decide the minimum window
        // and start and end index of sub string.
        int ans[] = {-1,0,0};

        while (r < source.length() && formed < required) {
            char ch = source.charAt(r);

            if(!windowCounts.containsKey(ch)) {
                windowCounts.put(ch,0);
            }
            windowCounts.put(ch,windowCounts.get(ch) + 1);

            if(targetMap.containsKey(ch) &&
                windowCounts.get(ch) == targetMap.get(ch)) {
                formed ++;
            }

            while (l<=r && formed == required) {

                ch = source.charAt(l);
                if (ans[0] == -1 || ans[0] > r-l+1){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(ch,windowCounts.get(ch) - 1);
                if(targetMap.containsKey(ch) &&
                        windowCounts.get(ch) < targetMap.get(ch))
                    formed--;
                l++;
            }
            r++;
        }

        return source.substring(ans[1],ans[2]+1);
    }
}

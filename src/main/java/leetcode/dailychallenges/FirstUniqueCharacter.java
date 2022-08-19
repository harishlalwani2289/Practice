package leetcode.dailychallenges;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        for(int i=0;i<s.length();i++) {
            if(frequency[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;

    }
}

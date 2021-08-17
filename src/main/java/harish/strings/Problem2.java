package harish.strings;

/**
 * Given a large number as string s and an integer k which denotes the
 * number of breakpoints we must put in the number k <= string length.
 * The task is to find maximum segment value after putting exactly k breakpoints.
 *
 * Examples:
 *
 * Input : s = "8754", k = 2
 * Output : Maximum number = 87
 * Explanation : We need to two breakpoints. After
 * putting the breakpoints, we get following options
 * 8 75 4
 * 87 5 4
 * The maximum segment value is 87.
 *
 * Input : s = "999", k = 1
 * Output : Maximum Segment Value = 99
 * Explanation : We need to one breakpoint. After
 * putting the breakpoint, we either get 99,9 or
 * 9,99.
 *
 * Solution Explaination: The break point will be such as the maximum number will be of
 * length stringLength-k
 * This becomes the sliding window problem where we have to find the maximum number of this length in the string
 */
public class Problem2 {
    public static void main(String[] args) {
        String input = "8704882247529954";
        int k = 7;

        // We have to find the maximum number of length input length - k
        int i = 0;
        int j = input.length()-k;
        int max = 0;
        while(j<input.length()) {
            if (max < Integer.parseInt(input.substring(i,j))) {
                max = Integer.parseInt(input.substring(i,j));
            }
            i++;
            j++;
        }
        System.out.println(max);
    }
}

package leetcode.dailychallenges;

import java.util.PriorityQueue;

/**
 * {@link <a href="https://leetcode.com/problems/split-array-into-consecutive-subsequences">...</a>}
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 3};
        System.out.println(isPossible(nums));
    }

    public static boolean isPossible(int[] nums) {

        PriorityQueue<int[]> resultSubsequences = new PriorityQueue<>((subsequence1, subsequence2) -> compare(subsequence1, subsequence2));

        for (int num : nums) {
            // Condition 1 - remove non-qualifying resultSubsequences
            while (!resultSubsequences.isEmpty() && resultSubsequences.peek()[1] + 1 < num) {
                int[] currentSubsequence = resultSubsequences.poll();
                int subsequenceLength = currentSubsequence[1] - currentSubsequence[0] + 1;
                if (subsequenceLength < 3) {
                    return false;
                }
            }
            //Condition 2 - create a new subsequence
            if (resultSubsequences.isEmpty() || resultSubsequences.peek()[1] == num) {
                resultSubsequences.add(new int[]{num, num});
            } else {
                // Condition 3 - add num to an existing subsequence
                int[] currentSubsequence = resultSubsequences.poll();
                resultSubsequences.add(new int[]{currentSubsequence[0], num});
            }
        }

        // If any subsequence is of length less than 3, return false
        while (!resultSubsequences.isEmpty()) {
            int[] currentSubsequence = resultSubsequences.poll();
            int subsequenceLength = currentSubsequence[1] - currentSubsequence[0] + 1;
            if (subsequenceLength < 3) {
                return false;
            }
        }

        return true;
    }

    private static int compare(int[] subsequence1, int[] subsequence2) {
        if (subsequence1[1] == subsequence2[1]) {
            return (subsequence1[1] - subsequence1[0]) - (subsequence2[1] - subsequence2[0]);
        }
        return (subsequence1[1] - subsequence2[1]);
    }
}

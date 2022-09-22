package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link <a href="https://leetcode.com/problems/subarray-sum-equals-k/">...</a>}
 */
public class NumberOfSubarraysWithSumK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        // We do this by prefix sum array where e keep track
        // of the sum till position i

        // Count to store the number of subarrays- our result
        int count = 0;

        // This map would contain the number of times we have encountered a sum before;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(0, 1);

        // Initial sum is zero
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];
            // Now we would check if we have got an entry for (sum - k) in our frequency map.
            // If yes we would increment our count
            if (frequencyMap.containsKey(sum - k)) {
                count += frequencyMap.get(sum - k);
            }

            // Also we would add an entry in frequency map of sum till this position
            frequencyMap.put(sum, frequencyMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

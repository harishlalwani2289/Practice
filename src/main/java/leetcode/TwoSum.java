package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2,4,11,3};
        int[] result = twoSum(numbers, 6);
        for(int i: result) {
            System.out.println(i);
        }

    }
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> numberIndexMap = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            if(numberIndexMap.containsKey(target - nums[i])) {
                if(i < numberIndexMap.get(target - nums[i])) {
                    result[0] = i;
                    result[1] = numberIndexMap.get(target - nums[i]);
                } else {
                    result[1] = i;
                    result[0] = numberIndexMap.get(target - nums[i]);
                }
                break;
            }else {
                numberIndexMap.put(nums[i], i);
            }

        }

        return result;
    }
}

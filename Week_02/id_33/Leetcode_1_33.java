/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums != null && nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                int result = target - nums[i];
                if (map.containsKey(result)) {
                    return new int[]{map.get(result), i};
                }
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}


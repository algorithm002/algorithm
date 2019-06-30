/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int maxSum = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}


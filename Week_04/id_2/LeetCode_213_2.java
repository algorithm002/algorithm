//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
// Example 1:
//
//
//Input: [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
//             because they are adjacent houses.
//
//
// Example 2:
//
//
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
//

package com.llz.algorithm.algorithm2019.fourthweek;

public class LeetCode_213_2 {

    /**
     * My original version. The code is not clean enough, However it definitely solves this problem.
     * The time complexity and space complexity are both O(n).
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        //0...n-2
        int[] max1 = new int[length - 1];
        max1[0] = nums[0];
        max1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length - 1; i++) {
            max1[i] = Math.max(max1[i - 2] + nums[i], max1[i - 1]);
        }
        int maxA = max1[length - 2];

        //1...n-1
        max1[0] = nums[1];
        max1[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i <= length - 2; i++) {
            max1[i] = Math.max(max1[i - 2] + nums[i + 1], max1[i - 1]);
        }
        int maxB = max1[length - 2];
        return Math.max(maxA, maxB);
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 7, 5, 3, 1};
        LeetCode_213_2 l = new LeetCode_213_2();
        System.out.println(l.rob(nums));
    }
}

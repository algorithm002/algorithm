package com.github.lifelab.leetcode.problemset;

/**
 * 删除排序数组中的重复项 @https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2019-06-04
 */
public class Solution26 {

    /**
     * 1 1 1 2 3 4 4 4
     *
     * @param nums
     * @return
     * @
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[left] != nums[i]) {
                left++;
                nums[left] = nums[i];
            }
        }
        return left + 1;
    }


}
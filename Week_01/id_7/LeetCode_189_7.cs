/*
 * @lc app=leetcode.cn id=189 lang=csharp
 *
 * [189] 旋转数组
 */
public class Solution {
    public void Rotate (int[] nums, int k) {
        k %= nums.Length;
        Reverse (nums, 0, nums.Length - 1);
        Reverse (nums, 0, k - 1);
        Reverse (nums, k, nums.Length - 1);
    }
    public void Reverse (int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
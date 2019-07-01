package com.mootal.algo.month_1.week_1.day5_198;

/**
 * Easy
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * 题解方案topics：
 * dp
 *
 * @author li tong
 * @date 2019/6/7 9:41
 * @see Object
 * @since 1.0
 */
public class LeetCode_198_025 {

  public static void main(String[] args) {
    int[] test = new int[]{2, 7, 1, 4, 9, 3};
    System.out.println(rob(test));
  }

  /**
   * 解法1 dp<p>
   *
   * @param nums
   * @return
   */
  static int rob(int[] nums) {
    int res = 0;
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }

}

package com.mootal.algo.month_1.week_4.day_23;

/**
 * Hard
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * A frog is crossing a river.
 * The river is divided into x units and at each unit there may or may not exist a stone.
 * The frog can jump on a stone, but it must not jump into the water.
 * <p>
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last stone.
 * Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * <p>
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units.
 * Note that the frog can only jump in the forward direction.
 * <p>
 * Note:
 * <li>The number of stones is ≥ 2 and is < 1,100.</li>
 * <li>Each stone's position will be a non-negative integer < 231.</li>
 * <li>The first stone's position is always 0.</li>
 * <p>
 * 题解方案topics：
 * dp
 *
 * @author li tong
 * @date 2019/6/25 11:41
 * @see Object
 * @since 1.0
 */
public class LeetCode_403_025 {

  public static void main(String[] args) {
    int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17, 2147483647};
    System.out.println(canCross1(stones));
  }

  public static boolean canCross1(int[] stones) {
    if (stones == null || stones.length == 0) {
      return false;
    }
    boolean[][] dp = new boolean[stones.length][stones.length + 1];
    dp[0][1] = true;
    for (int i = 1; i < stones.length; i++) {
      for (int j = 0; j < i; j++) {
        int jump = stones[i] - stones[j];
        if (jump < 0 || jump > stones.length || !dp[j][jump]) continue;
        if (jump - 1 >= 0) dp[i][jump - 1] = true;
        dp[i][jump] = true;
        if (jump + 1 <= stones.length) dp[i][jump + 1] = true;
        if (i == stones.length - 1) {
          return true;
        }
      }
    }
    return false;
  }

}

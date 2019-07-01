package com.mootal.algo.day9_72;

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
 * Given two words word1 and word2,
 * find the minimum number of operations required to convert word1 to word2.
 * <p>
 * 题解方案topics：
 * string、dp
 *
 * @author li tong
 * @date 2019/6/11 10:06
 * @see Object
 * @since 1.0
 */
public class LeetCode_72_025 {

  public static void main(String[] args) {
    String word1 = "rose", word2 = "horse";
    System.out.println(minDistance(word1, word2));
    System.out.println(minDistanceDP(word1, word2));
  }

  /**
   * 递归解法 <p>
   *
   * @param word1
   * @param word2
   * @return
   */
  public static int minDistance(String word1, String word2) {
    char[] w1 = word1.toCharArray();
    char[] w2 = word2.toCharArray();
    int l1 = w1.length, l2 = w2.length;
    int[][] mem = new int[l1][l2];
    return helpWithMem(0, w1, 0, w2, mem);
  }

  private static int help(int i, char[] w1, int j, char[] w2, int[][] mem) {
    int insertCnt, deleteCnt, replaceCnt;
    if (i == w1.length) {
      return w2.length - j;
    }
    if (j == w2.length) {
      return w1.length - i;
    }
    int res = 0;
    if (w1[i] == w2[j]) {
      res = help(i + 1, w1, j + 1, w2, mem);
      return res;
    } else {
      deleteCnt = help(i + 1, w1, j, w2, mem);
      insertCnt = help(i, w1, j + 1, w2, mem);
      replaceCnt = help(i + 1, w1, j + 1, w2, mem);
      res = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
    }
    return res;
  }

  private static int helpWithMem(int i, char[] w1, int j, char[] w2, int[][] mem) {
    int insertCnt, deleteCnt, replaceCnt;
    if (i == w1.length) {
      return w2.length - j;
    }
    if (j == w2.length) {
      return w1.length - i;
    }
    if (mem[i][j] > 0) {
      return mem[i][j];
    }
    int res = 0;
    if (w1[i] == w2[j]) {
      res = helpWithMem(i + 1, w1, j + 1, w2, mem);
      return res;
    } else {
      deleteCnt = helpWithMem(i + 1, w1, j, w2, mem);
      insertCnt = helpWithMem(i, w1, j + 1, w2, mem);
      replaceCnt = helpWithMem(i + 1, w1, j + 1, w2, mem);
      mem[i][j] = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
    }
    return mem[i][j];
  }

  /**
   * DP解法 <p>
   *
   * @param word1
   * @param word2
   * @return
   */
  public static int minDistanceDP(String word1, String word2) {
    char[] w1 = word1.toCharArray();
    char[] w2 = word2.toCharArray();
    int l1 = w1.length, l2 = w2.length;
    int[][] dp = new int[l1 + 1][l2 + 1];
    for (int i = 0; i <= l1; ++i) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= l2; ++i) {
      dp[0][i] = i;
    }
    for (int i = 1; i <= l1; ++i) {
      for (int j = 1; j <= l2; ++j) {
        if (w1[i - 1] == w2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
      }
    }
    return dp[l1][l2];
  }

}

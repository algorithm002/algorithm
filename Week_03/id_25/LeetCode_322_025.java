package com.mootal.algo.day_16;

/**
 * Medium
 * <p>
 * 属于背包问题 BackPack<p>
 * https://www.cnblogs.com/Christal-R/p/Dynamic_programming.html<p>
 * http://www.cs.ust.hk/mjg_lib/Classes/COMP3711H_Fall16/lectures/19_DPII.pdf<p>
 * https://www.jianshu.com/p/f38f4af13177<p>
 * https://www.cnblogs.com/xym4869/p/8513801.html<p>
 * https://www.cnblogs.com/fengziwei/p/7750849.html<p>
 * 一、问题描述：有n 个物品，它们有各自的重量和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
 * <p>
 * 二、总体思路：根据动态规划解题步骤（问题抽象化、建立模型、寻找约束条件、判断是否满足最优性原理、
 * 找大问题与小问题的递推关系式、填表、寻找解组成）找出01背包问题的最优解以及解组成，然后编写代码实现；
 * <p>
 * 三、动态规划的原理及过程：
 * <p>
 * 　　eg：number＝4，capacity＝8
 * 1、原理
 * <p>
 * 　　动态规划与分治法类似，都是把大问题拆分成小问题，通过寻找大问题与小问题的递推关系，
 * 解决一个个小问题，最终达到解决原问题的效果。但不同的是，分治法在子问题和子子问题等上被重复计算了很多次，
 * 而动态规划则具有记忆性，通过填写表把所有已经解决的子问题答案纪录下来，在新问题里需要用到的子问题可以直接提取，
 * 避免了重复计算，从而节约了时间，所以在问题满足最优性原理之后，用动态规划解决问题的核心就在于填表，表填写完毕，最优解也就找到。
 * 2、过程
 * 3、空间优化
 * <p>
 * 四、蛮力法检验：
 * <p>
 * 　　1) 蛮力法是解决01背包问题最简单最容易的方法，但是效率很低
 * <p>
 * 　　2) (X1，X2，…，Xn)其中Xi＝0或1表示第i件商品选或不选，共有n(n-1)/2种可能；
 * <p>
 * 　　3) 最简单的方式就是把所有拿商品的方式都列出来，最后再做判断此方法是否满足装包条件，
 * 并且通过比较和记录找出最优解和解组成（如果满足则记录此时的价值和装的方式，当下一次的装法优于这次，
 * 则更新记录，如此下去到最后便会找到最优解，同时解组成也找到）；
 * <p>
 * 　　4) n件商品，共有n(n-1)/2种可能，故蛮力法的效率是指数级别的，可见效率很低;
 * <p>
 * 　　5) 蛮力法效率低不建议采取，但可以用于检验小规模的动态规划解背包问题的正确性和可行性，
 * <p>
 * 五、总结：
 * <p>
 * 　　对于01背包问题，用蛮力法与用动态规划解决得到的最优解和解组成是一致的，所以动态规划解决此类问题是可行的。
 * 动态规划效率为线性，蛮力法效率为指数型，结合以上内容和理论知识可以得出，解决此问题用动态规划比用蛮力法适合得多。
 * 对于动态规划不足的是空间开销大，数据的存储得用到二维数组；好的是，当前问题的解只与上一层的子问题的解相关，
 * 所以，可以把动态规划的空间进行优化，使得空间效率从O(n*c)转化为O(c)，
 * 遗憾的是，虽然优化了空间，但优化后只能求出最优解，解组成的探索方式在该方法运行的时候已经被破坏掉；
 * 总之动态规划和优化后的动态规划各有优缺点，可以根据实际问题的需求选择不同的方式。
 * <p>
 * 六、引申：
 * <p>
 * 　　动态规划可以解决哪些类型的问题？
 * <p>
 * 　　待解决的原问题较难，但此问题可以被不断拆分成一个个小问题，而小问题的解是非常容易获得的；
 * 如果单单只是利用递归的方法来解决原问题，那么采用的是分治法的思想，
 * 动态规划具有记忆性，将子问题的解都记录下来，以免在递归的过程中重复计算，从而减少了计算量。
 * <p>
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * 题解方案topics：
 * dp
 *
 * @author li tong
 * @date 2019/6/17 18:19
 * @see Object
 * @since 1.0
 */
public class LeetCode_322_025 {

  public static void main(String[] args) {
    int[] coins = new int[]{1, 2, 5};
    int amount = 11;
    System.out.println(coinChange2(coins, amount));
  }

  public static int coinChange2(int[] coins, int amount) {
    if (coins == null || coins.length == 0) {
      return 0;
    }
    int[] dp = new int[amount + 1];
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      dp[i] = amount + 1;
    }
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static int coinChange1(int[] coins, int amount) {
    if (coins == null || coins.length == 0) {
      return 0;
    }
    int[] dp = new int[amount + 1];
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      dp[i] = amount + 1;
    }
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

}

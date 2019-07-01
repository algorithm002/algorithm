package com.leecode.week04;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/ 还是爬楼梯问题，这次换成动态规划的方式来做
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Leetcode_70_35 {

    public static void main(String[] args) {
        Leetcode_70_35 lc = new Leetcode_70_35();
        System.out.println(lc.climbStairs(1));
        System.out.println(lc.climbStairs(2));
        System.out.println(lc.climbStairs(3));
        System.out.println(lc.climbStairs(4));
        System.out.println(lc.climbStairs(6));
        System.out.println(lc.climbStairs(8));
        System.out.println(lc.climbStairs(20));

    }

    /**
     * 思路分析: 1.楼梯在1阶时候，没得选择，只能是走一步,走法也就是一种 2.楼梯两阶的时候，可以一步+一步或者一次性两步 (1,1) (2)两种 3.楼梯三阶的时候，我们考虑
     * 怎样走到3阶的，反正规则就是一次只能走一步或者走两步 a.一次走了一步就到三步了，那么前面就要先走两步了 b.一次走了两步到了三步，那么前面就要走一步
     *
     * 对任意的N>=3的时候都有这种关系 dp[n]=dp[n-1]+d[n-2],表示的是剩下一步走到N的情况和剩下走两步走到N的情况，所以要走到N步就是前面两者的和
     */
    public int climbStairs(int n) {
        int oneStep = 1;
        int twoStep = 2;

        switch (n) {
            case 1:
                return oneStep;
            case 2:
                return twoStep;
            default:
                int[] dp = new int[n];
                dp[0] = oneStep;
                dp[1] = twoStep;
                for (int i = 2; i < n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
                return dp[n - 1];
        }


    }
}

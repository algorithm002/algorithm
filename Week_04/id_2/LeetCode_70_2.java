//You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
// Note: Given n will be a positive integer.
//
// Example 1:
//
//
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//
// Example 2:
//
//
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
//

package com.llz.algorithm.algorithm2019.fourthweek;

public class LeetCode_70_2 {

    private int count = 0;

    public int climbStairs(int n) {
        int[] mem = new int[n + 1];
        return climbStairsByTraverseOptimised(n, mem);
        //return climbStairsByDP(n);
    }

    /**
     * Time complexity and space complexity are both O(n).
     *
     * @param n
     * @return
     */
    public int climbStairsByDP(int n) {
        if (n < 2) return 1;
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }

    public void climbStairsByTraverse(int cur, int n) {
        if (cur >= n) {
            if (cur == n)
                count++;
            return;
        }
        climbStairsByTraverse(cur + 1, n);
        climbStairsByTraverse(cur + 2, n);
    }

    public int climbStairsByTraverseOptimised(int n, int[] mem) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (mem[n] > 0)
            return mem[n];
        mem[n] = climbStairsByTraverseOptimised(n - 1, mem) + climbStairsByTraverseOptimised(n - 2, mem);
        return mem[n];
    }
}

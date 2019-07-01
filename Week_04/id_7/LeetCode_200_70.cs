/*
 * @lc app=leetcode.cn id=70 lang=csharp
 *
 * [70] 爬楼梯
 */
using System.Collections.Generic;

public class Solution {
    // 方法1： 暴力法+记忆化
    // Dictionary<int, int> dic = new Dictionary<int, int> ();
    // public int ClimbStairs (int n) {
    //     if (n == 1) {
    //         return 1;
    //     }

    //     if (n == 2) {
    //         return 2;
    //     }

    //     int A;
    //     if (dic.ContainsKey (n - 1)) {
    //         A = dic[n - 1];
    //     } else {
    //         A = ClimbStairs (n - 1);
    //         dic.Add (n - 1, A);
    //     }

    //     int B;
    //     if (dic.ContainsKey (n - 2)) {
    //         B = dic[n - 2];
    //     } else {
    //         B = ClimbStairs (n - 2);
    //         dic.Add (n - 2, B);
    //     }

    //     return A + B;
    // }

    // 方法2：动态规划，当然不是我自己想出来的😂
    public int ClimbStairs (int n) {
        if (n == 1) {
            return 1;
        }
    
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
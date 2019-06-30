/*
 * @lc app=leetcode.cn id=455 lang=csharp
 *
 * [455] 分发饼干
 */
using System;

public class Solution {
    // 解法1：就是先排序，后暴力查找，计数，最后返回计数结果
    public int FindContentChildren (int[] g, int[] s) {
        Array.Sort (g);
        Array.Sort (s);
        int count = 0;
        int sIndex = 0;
        for (int i = 0; i < g.Length; i++) {
            for (int j = sIndex; j < s.Length; j++) {
                if (s[j] >= g[i]) {
                    sIndex = j + 1;
                    count++;
                    if (j == s.Length - 1) {
                        return count;
                    }
                    break;
                }
            }
        }

        return count;
    }
}
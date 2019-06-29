/*
 * @lc app=leetcode.cn id=169 lang=csharp
 *
 * [169] 求众数
 */
using System.Collections.Generic;

public class Solution {
    // 解法1
    // 暴力法，直接双层循环遍历所有数字，统计出现次数，大于nums.Length/2就直接返回
    // 优化点：记录之前统计过的数字，再次遇到，则不再统计
    public int MajorityElement (int[] nums) {
        HashSet<int> hs = new HashSet<int> ();
        for (int i = 0; i < nums.Length; i++) {
            if (hs.Contains (nums[i])) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < nums.Length; j++) {
                if (nums[i] == nums[j]) { count++; }
            }
            if (count > nums.Length / 2) {
                return nums[i];
            }
            hs.Add (nums[i]);
        }

        return 0;
    }
}
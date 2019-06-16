/*
 * @lc app=leetcode.cn id=1 lang=csharp
 *
 * [1] 两数之和
 */

using System.Collections.Generic;

public class Solution {
    public int[] TwoSum (int[] nums, int target) {
        Dictionary<int, int> dicNums = new Dictionary<int, int> ();
        for (int i = 0; i < nums.Length; i++) {
            if (!dicNums.ContainsKey (target - nums[i])) {
                if (!dicNums.ContainsKey (nums[i])) {
                    dicNums.Add (nums[i], i);
                }
            } else {
                return new int[] { dicNums[target - nums[i]], i };
            }
        }

        return null;
    }
}
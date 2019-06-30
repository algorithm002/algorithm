/*
 * @lc app=leetcode.cn id=169 lang=csharp
 *
 * [169] 求众数
 */
using System;
using System.Collections.Generic;

public class Solution {
    // 解法1
    // 暴力法，直接双层循环遍历所有数字，统计出现次数，大于nums.Length/2就直接返回
    // 优化点：记录之前统计过的数字，再次遇到，则不再统计
    // public int MajorityElement (int[] nums) {
    //     HashSet<int> hs = new HashSet<int> ();
    //     for (int i = 0; i < nums.Length; i++) {
    //         if (hs.Contains (nums[i])) {
    //             continue;
    //         }
    //         int count = 0;
    //         for (int j = 0; j < nums.Length; j++) {
    //             if (nums[i] == nums[j]) { count++; }
    //         }
    //         if (count > nums.Length / 2) {
    //             return nums[i];
    //         }
    //         hs.Add (nums[i]);
    //     }

    //     return 0;
    // }

    // 解法2，肯定不是自己想出来的，看答案知道的
    // public int MajorityElement (int[] nums) {
    //     // 摩尔投票法
    //     int zongshu = nums[0];
    //     int count = 1;

    //     for (int i = 1; i < nums.Length; i++) {
    //         if (zongshu == nums[i]) {
    //             count++;
    //             if (count > (nums.Length / 2)) {
    //                 return zongshu;
    //             }
    //         } else {
    //             count--;
    //         }

    //         if (count == 0) {
    //             zongshu = nums[i];
    //             count = 1;
    //         }
    //     }

    //     return zongshu;
    // }

    // 解法3：哈希表，先简单遍历一下，记录所有数出现的次数，然后再遍历哈希表，找出答案
    // public int MajorityElement (int[] nums) {
    //     Dictionary<int, int> dicCount = new Dictionary<int, int> ();
    //     for (int i = 0; i < nums.Length; i++) {
    //         if (dicCount.ContainsKey (nums[i])) {
    //             dicCount[nums[i]]++;
    //         } else {
    //             dicCount.Add (nums[i], 1);
    //         }
    //     }

    //     foreach (var item in dicCount) {
    //         if (item.Value > nums.Length / 2) {
    //             return item.Key;
    //         }
    //     }

    //     return 0;
    // }

    // 解法4：排序，方法肯定也不是我想出来的，使用标准函数进行排序，然后直接返回中间数，即为答案
    // public int MajorityElement (int[] nums) {
    //     Array.Sort (nums);
    //     return nums[nums.Length / 2];
    // }

    // 解法5 看答案，还有一个随机法，这个哪能想的出来，这么奇葩的方法，这里就不写了

    // 方法6：分治法，这个才是今天的重点
    public int MajorityElement (int[] nums) {
        return DivideConquer (nums, 0, nums.Length - 1);
    }

    public int DivideConquer (int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (right - left) / 2 + left;
        int leftRes = DivideConquer (nums, left, mid);
        int rightRes = DivideConquer (nums, mid + 1, right);

        if (leftRes == rightRes) {
            return leftRes;
        }

        int lftCount = GetCount (nums, leftRes, left, right);
        int rgtCount = GetCount (nums, rightRes, left, right);

        return lftCount > rgtCount? leftRes : rightRes;
    }

    public int GetCount (int[] nums, int curNum, int left, int right) {
        int count = 0;
        for (int i = left; i < right + 1; i++) {
            if (curNum == nums[i])
                count++;
        }

        return count;
    }

}
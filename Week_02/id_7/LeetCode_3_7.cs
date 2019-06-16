/*
 * @lc app=leetcode.cn id=3 lang=csharp
 *
 * [3] 无重复字符的最长子串
 */
using System;
using System.Collections.Generic;

public class Solution {
    public int LengthOfLongestSubstring (string s) {
        Dictionary<char, int> dic = new Dictionary<char, int> ();
        int ans = 0;
        for (int left = 0, right = 0; right < s.Length; right++) {
            if (dic.ContainsKey (s[right])) {
                left = Math.Max (left, dic[s[right]]);
                dic[s[right]] = right + 1;
            } else {
                dic.Add (s[right], right + 1);
            }
            ans = Math.Max (ans, right - left + 1);
        }
        return ans;
    }
}
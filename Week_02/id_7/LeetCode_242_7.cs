/*
 * @lc app=leetcode.cn id=242 lang=csharp
 *
 * [242] 有效的字母异位词
 */
using System.Collections.Generic;

public class Solution {
    public bool IsAnagram (string s, string t) {
        if (s.Length != t.Length) {
            return false;
        }

        int[] arrRes = new int[26];
        for (int i = 0; i < s.Length; i++) {
            arrRes[s[i] - 'a']++;
            arrRes[t[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (arrRes[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
/*
 * @lc app=leetcode.cn id=720 lang=csharp
 *
 * [720] 词典中最长的单词
 */
using System;
using System.Collections.Generic;

public class Solution {
    // 先排序，后将所有单词放入集合中，遍历每一个单词，
    // 然后对于每个单词进行每次去除末尾一个字母的循环操作，
    // 如果可以执行到单词长度为0，则与strRes进行比较，比strRes长，则替换strRes
    public string LongestWord (string[] words) {
        if (words.Length == 1) {
            return words[0];
        }

        Array.Sort (words);
        string strRes = words[0];

        HashSet<string> hsWord = new HashSet<string> ();
        foreach (var word in words) {
            hsWord.Add (word);
        }

        foreach (var word in words) {
            if (word.Length <= 1 || word.Length <= strRes.Length) {
                continue;
            }
            string temp = word;
            while (temp.Length > 0) {
                if (!hsWord.Contains (temp)) {
                    break;
                }
                temp = temp.Substring (0, temp.Length - 1);
                if (temp.Length == 0 && strRes.Length < word.Length) {
                    strRes = word;
                }
            }
        }

        return strRes;
    }
}
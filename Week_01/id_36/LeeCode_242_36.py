#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#
# 思路 : 空间换时间
#
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        l_list = [0]*(26+97)

        for i in s:
            l_list[ord(i)] += 1

        for i in t:
            l_list[ord(i)] -= 1
        
        for i in l_list:
            if i != 0:
                return False
        
        return True


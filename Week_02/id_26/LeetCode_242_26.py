#
# @lc app=leetcode.cn id=242 lang=python
#
# [242] 有效的字母异位词
#
# https://leetcode-cn.com/problems/valid-anagram/description/
#
# algorithms
# Easy (53.28%)
# Likes:    82
# Dislikes: 0
# Total Accepted:    32.3K
# Total Submissions: 60.6K
# Testcase Example:  '"anagram"\n"nagaram"'
#
# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
#
# 示例 1:
#
# 输入: s = "anagram", t = "nagaram"
# 输出: true
#
#
# 示例 2:
#
# 输入: s = "rat", t = "car"
# 输出: false
#
# 说明:
# 你可以假设字符串只包含小写字母。
#
# 进阶:
# 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
#
#


class Solution(object):
    """
    解法1：排序比较
    解法2：清点字母数量
    """
    def isAnagram1(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        return sorted(s) == sorted(t)

    def isAnagram2(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        map = {}
        for i in s:
            if i not in map:
                map[i] = 0
            map[i] += 1
        for i in t:
            if i not in map:
                return False
            map[i] -= 1
            if map[i] < 0:
                return False
        for i in map:
            if map[i] != 0:
                return False
        return True


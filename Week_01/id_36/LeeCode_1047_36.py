#
# @lc app=leetcode id=1047 lang=python3
#
# [1047] 删除字符串中的所有相邻重复项
#
# 思路 : 判断栈顶的元素和即将加入的元素是否相等，相等则弹出栈顶，否则压入栈顶
#
class Solution:
    def removeDuplicates(self, S: str) -> str:
        stack = ['-']
        for s in S:
            if s == stack[-1]:
                stack.pop()
            else:
                stack.append(s)
        
        return ''.join(stack[1:])


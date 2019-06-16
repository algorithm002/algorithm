class Solution(object):
    def removeOuterParentheses(self, S):
        """
        :type S: str
        :rtype: str
        """
        if not S:
            return S
        ret, t = '', 0
        for i in S:
            if i == '(':
                t += 1
                if t > 1:
                    ret += i
            if i == ')':
                t -= 1
                if t > 0:
                    ret += i
        return ret


print Solution().removeDuplicates('(()())(())')
print Solution().removeDuplicates('(()())(())(()(()))')

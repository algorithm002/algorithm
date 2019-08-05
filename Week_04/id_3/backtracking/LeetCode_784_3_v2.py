"""
尝试非递归解决
"""


class Solution:
    def letterCasePermutation(self, ss):
        if not ss:
            return []

        results = ['']
        for c in ss:
            _results = []
            for r in results:
                if c.islower() or c.isupper():
                    _results.append(r + c.upper())
                    _results.append(r + c.lower())
                else:
                    _results.append(r + c)

            results = _results
        return results


s = Solution()
print(s.letterCasePermutation('a1b2'))
print(s.letterCasePermutation('3z4'))
print(s.letterCasePermutation('12345'))

class Solution:
    def letterCasePermutation(self, ss):
        results = []
        if not ss:
            return results
        self.recursion(ss, 0, [], results)
        return results

    def recursion(self, ss, i, curr_arr, results):
        if i == len(ss):
            results.append(''.join(curr_arr))
            return

        c = ss[i]
        self.recursion(ss, i + 1, curr_arr + [c], results)
        if c.isupper():
            self.recursion(ss, i + 1, curr_arr + [c.lower()], results)
        elif c.islower():
            self.recursion(ss, i + 1, curr_arr + [c.upper()], results)


s = Solution()
print(s.letterCasePermutation('a1b2'))
print(s.letterCasePermutation('3z4'))
print(s.letterCasePermutation('12345'))

import re
class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        s = S.lower()
        results = ['']
        f = []

        for i in range(0, len(s)):
            for j in range(len(results)):
                if re.match('[a-z]', s[i]):
                    f.append(results[j] + s[i].upper())
                results[j] = results[j] + s[i]
            results = results + f
            f = []
        return results

test = "a1B2"

print(Solution().letterCasePermutation(test))
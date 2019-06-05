class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        if not strs:
            return []
        ret = {}
        for s in strs:
            key = "".join(sorted(s))
            if key not in ret:
                ret[key] = []
            ret[key].append(s)
        return ret.values()


print Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])

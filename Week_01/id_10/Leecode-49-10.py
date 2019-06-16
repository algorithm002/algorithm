class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        strmap={}
        for s in strs:
            ss=''.join(sorted(s))
            strarr=strmap.get(ss,[])
            strarr.append(s)
            strmap[ss]=strarr
        return list(strmap.values())
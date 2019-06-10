class Solution:
    def removeOuterParentheses(self, S: str) -> str:
        result=""
        index=0
        for c in S:
            if c=='(':
                if index!=0:
                    result+=c
                index+=1
            else:
                index-=1
                if index!=0:
                    result+=c
        return result
class Solution:
    def myPow(self, x: float, n: int) -> float:
        isNegitive=False
        if n==0:
            return 1.0
        if n==1:
            return x
        if n<0:
            isNegitive=True
            n=0-n
        res,p=1,x
        while n!=0:
            if n&1==1:
                res*=p
            p*=p
            n>>=1
        if isNegitive:
            res=1.0/res
        return res
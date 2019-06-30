class Solution:
    def climbStairs(self, n: int) -> int:
        f = [0 for i in range(n + 1)]
        for i in range(n+1):
            if i <= 1:
                f[i] = 1
            else:
                f[i] = f[i-1] + f[i-2]
        return f[n]
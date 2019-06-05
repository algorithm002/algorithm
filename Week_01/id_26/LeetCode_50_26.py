class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """

        if n == 0:
            return 1
        if n == 1:
            return x
        if n < 0:
            return 1.0 / self.myPow(x, -n)

        t = self.myPow(x, n/2)
        if n & 1 == 0:
            return t * t
        else:
            return x * t * t


print Solution().myPow(2.00000, 10)
print Solution().myPow(2.10000, 3)
print Solution().myPow(2.00000, -2)
print Solution().myPow(2.00000, -2147483648)

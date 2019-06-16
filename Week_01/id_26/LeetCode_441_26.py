class Solution(object):
    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """
        left, right = 0, n
        while left <= right:
            mid = (right + left) / 2
            k = mid * (mid + 1)
            if k <= 2 * n:
                left = mid + 1
            else:
                right = mid - 1
        return right


print Solution().arrangeCoins(1)
# print Solution().arrangeCoins(5)
# print Solution().arrangeCoins(8)

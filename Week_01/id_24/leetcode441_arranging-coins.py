import math
def arrangeCoins(n):
        """
        :type n: int
        :rtype: int
        """
        # s1
        # for i in range(int(math.sqrt(2 * n)) + 1):
        #     if n - i * (i+1) / 2 <= i:
        #         return i

        # s2
        # i = int(math.sqrt(2 * n))
        # print(i)
        # while i >= 0:
        #     if n - i * (i+1) / 2 < 0:
        #         i = i - 1
        #     else:
        #         return i

        # s3
        return int(math.ceil((-3 + math.sqrt(9 + 8 * n))/2))

print(arrangeCoins(6))

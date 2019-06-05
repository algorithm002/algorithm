class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        i, j = 0, len(height)-1
        ret, left_max, right_max = 0, 0, 0
        while i <= j:
            left_max = max(left_max, height[i])
            right_max = max(right_max, height[j])
            if left_max < right_max:
                ret += (left_max - height[i])
                i += 1
            else:
                ret += (right_max - height[j])
                j -= 1
        return ret

    def trap2(self, height):
        if not height:
            return 0

        max_height = height.index(max(height))
        ret = 0
        
        max_baffle = 0
        for i in range(1, max_height):
            max_baffle = max(height[i - 1], max_baffle)
            if height[i] < max_baffle:
                ret += max_baffle - height[i]

        max_baffle = 0
        for i in range(len(height) - 2, max_height, -1):
            max_baffle = max(height[i + 1], max_baffle)
            if height[i] < max_baffle:
                ret += max_baffle - height[i]
        return ret


print Solution().trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])
print Solution().trap([5, 2, 1, 2, 1, 5])

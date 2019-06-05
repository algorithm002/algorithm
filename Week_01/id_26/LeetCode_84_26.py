class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """

        heights.append(0)
        ret = 0
        stack = [-1]
        for i in xrange(len(heights)):
            while heights[i] < heights[stack[-1]]:
                h = heights[stack.pop()]
                w = i - stack[-1] - 1
                ret = max(ret, h * w)
            stack.append(i)
        return ret
        

# print Solution().largestRectangleArea([1])
print Solution().largestRectangleArea([1, 1])
print Solution().largestRectangleArea([2, 1, 5, 6, 2, 3])
print Solution().largestRectangleArea([2, 1, 2])        





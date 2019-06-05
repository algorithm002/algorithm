class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if len(heights)==0:
            return 0
        stack=collections.deque()
        maxarea=0
        for i in range(len(heights)):
            h=heights[i]
            l=len(stack)
            if l>0:
                startindex=stack[len(stack)-1]
            while l>0 and heights[startindex]>h:
                popindex=stack.pop()
                l-=1
                startindex=-1
                if l>0:
                    startindex=stack[l-1]
                area=(i-startindex-1)*heights[popindex]
                if maxarea<area:
                    maxarea=area
            stack.append(i)
        lastindex=stack[len(stack)-1]
        for i in range(len(stack)-1,-1,-1):
            if i>0:
                startindex=stack[i-1]
            else:
                startindex=-1
            area=heights[stack[i]]*(lastindex-startindex)
            if maxarea<area:
                maxarea=area
        return maxarea
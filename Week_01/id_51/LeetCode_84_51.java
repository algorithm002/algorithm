class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxArea = 0;
        int size = heights.length;
        for (int cur = 0; cur < size; cur++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[cur]) {
                int area = heights[stack.pop()] * (cur - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(cur);
        }

        while (stack.peek() != -1) {
            int area = heights[stack.pop()] * (size - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

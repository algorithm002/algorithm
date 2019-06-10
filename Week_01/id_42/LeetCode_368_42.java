package aleetcode.Largest_Rectangle_in_Histogram.Largest_Rectangle;

import java.util.Stack;

public class solution {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            // 把堆栈中比heights[i]大的元素都pop出，并计算面积
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                // 面积计算公式：(i - 1-stack.peek() ) * heights[top])
                int temp = (i-1-stack.peek())*heights[top];
                System.out.println(temp);
                max = Math.max(max, (i - 1 - stack.peek()) * heights[top]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int top = stack.pop();
            int temp = (heights.length - 1 - stack.peek()) * heights[top];
            System.out.println(temp);

            max = Math.max(max, (heights.length - 1 - stack.peek()) * heights[top]);
        }
        return max;

    }


}

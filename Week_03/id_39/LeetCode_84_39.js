/**
 * @param {number[]} heights
 * @return {number}
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 回顾第一周视频，以栈的解法解答该题目
 */
class newStack {
    constructor () {
        this.arr = [...arguments];
    }
    peek () {
        return this.arr[this.arr.length - 1];
    }
    push (node) {
        this.arr.push(node);
    }
    pop () {
        return this.arr.pop();
    }
}

var largestRectangleArea = function(heights) {
    let stack = new newStack(-1), maxArea = 0;
    
    for (let i = 0; i < heights.length; i++) {
        while(heights[i] < heights[stack.peek()] && stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1 ));
        }
        stack.push(i);
    }
    while (stack.peek() != -1) {
        maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1 ));
    }
    return maxArea;
};
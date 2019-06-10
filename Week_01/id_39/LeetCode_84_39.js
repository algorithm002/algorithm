/**
 * @param {number[]} heights
 * @return {number}
 * 目前只能理解暴力法。。。另一种单调栈的等理解之后添加
 */
// 暴力法，计算每一种的可能 O(n^2)
var largestRectangleArea = function(heights) {
    if (!heights.length) {
        return 0;
    }
    let maxArea = 0;
    for (let i = 0; i < heights.length; i++) {
        let min = heights[i];
        for (let j = i; j < heights.length; j++) {
            if (heights[j] < min) {
                min = heights[j];
            }
            let area = (j - i + 1) * min;
            if (area > maxArea) {
                maxArea = area;
            }
        }
    }
    return maxArea;
};

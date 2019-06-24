/**
 * @param {number[][]} matrix
 * @return {number}
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * dfs + 记忆化
 */

var direction = [[0, 1], [1, 0], [-1, 0], [0, -1]];

var dfs = function (matrix, i, j, memo) {
    let m = matrix.length, n = matrix[0].length;
    let index = i * n + j;
    if (memo[index] != -1) {
        return memo[index];
    }
    let max = 1;
    
    for (let d = 0; d < direction.length; d++) {
        let x = i + direction[d][0], y = j + direction[d][1];
        if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
            max = Math.max(max, dfs(matrix, x, y, memo) + 1);
        }
    }
    memo[index] = max;
    return max;
}

var longestIncreasingPath = function(matrix) {
    if (!matrix || !matrix.length) {
        return 0;
    }
    let m = matrix.length, n = matrix[0].length;
    let max = 1;
    let memo = new Array(m*n).fill(-1);
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            max = Math.max(max, dfs(matrix, i, j, memo));
        }
    }
    return max;
};
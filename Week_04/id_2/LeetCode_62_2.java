//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
// How many possible unique paths are there?
//
//
//Above is a 7 x 3 grid. How many possible unique paths are there?
//
// Note: m and n will be at most 100.
//
// Example 1:
//
//
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
//
//
// Example 2:
//
//
//Input: m = 7, n = 3
//Output: 28
//

package com.llz.algorithm.algorithm2019.fourthweek;

public class LeetCode_62_2 {
    /**
     * The time complexity and space complexity are both O(m*n).
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        if (m == 1 && n == 1)
            return 1;
        int[][] pathArray = new int[n][m];
        pathArray[0][0] = 0;
        for (int i = 1; i < n; i++)
            pathArray[i][0] = 1;
        for (int i = 1; i < m; i++)
            pathArray[0][i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                pathArray[i][j] = pathArray[i - 1][j] + pathArray[i][j - 1];
            }
        }
        return pathArray[n - 1][m - 1];
    }
}

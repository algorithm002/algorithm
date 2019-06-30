//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// Note: m and n will be at most 100.
//
// Example 1:
//
//
//Input:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//Output: 2
//Explanation:
//There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
//
//

package com.llz.algorithm.algorithm2019.fourthweek;

public class LeetCode_63_2 {

    /**
     * My first version.
     * Time complexity and space complexity are both O(m*n).
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1)
            return 1;
        int[][] dpArray = new int[obstacleGrid.length][obstacleGrid[0].length];
        dpArray[0][0] = 0;
        for (int i = 1; i < dpArray.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                dpArray[i][0] = 0;
                break;
            } else
                dpArray[i][0] = 1;
        }
        for (int i = 1; i < dpArray[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                dpArray[0][i] = 0;
                break;
            } else
                dpArray[0][i] = 1;
        }
        for (int i = 1; i < dpArray.length; i++) {
            for (int j = 1; j < dpArray[0].length; j++)
                if (obstacleGrid[i][j] == 1)
                    dpArray[i][j] = 0;
                else
                    dpArray[i][j] = dpArray[i - 1][j] + dpArray[i][j - 1];
        }
        return dpArray[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    /**
     * My second version.
     * Reduce space complexity to O(1).
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesOptimised(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < row; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0;
        for (int j = 1; j < col; j++)
            obstacleGrid[0][j] = obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1 ? 1 : 0;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[row - 1][col - 1];
    }


    public static void main(String[] args) {
        int[][] obstacles = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        LeetCode_63_2 l = new LeetCode_63_2();
        System.out.println(l.uniquePathsWithObstacles(obstacles));
        System.out.println(l.uniquePathsWithObstaclesOptimised(obstacles));
    }
}

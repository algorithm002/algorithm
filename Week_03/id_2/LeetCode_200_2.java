//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
//
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
//
//
// Example 2:
//
//
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
//

package com.llz.algorithm.algorithm2019.thirdweek;

public class LeetCode_200_2 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0) return;
        if (i == grid.length) return;
        if (j == grid[i].length)return;
        if (visited[i][j] == true || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j + 1);
    }

    public static void main(String[] args) {
        // char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] grid = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        LeetCode_200_2 l = new LeetCode_200_2();
        System.out.println(l.numIslands(grid));
    }
}

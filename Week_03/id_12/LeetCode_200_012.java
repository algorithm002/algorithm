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


class Solution {

  int[] x = {1, 0, -1, 0};
  int[] y = {0, -1, 0, 1};

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          count++;
          sink(grid, i, j);
        }
      }
    }
    return count;
  }

  private void sink(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1 || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    for (int index = 0; index < 4; index++) {
      sink(grid, i + x[index], j + y[index]);
    }
  }
}
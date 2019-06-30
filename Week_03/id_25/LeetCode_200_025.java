package com.mootal.algo.day15_37;

import java.util.LinkedList;

/**
 * Medium
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * 题解方案topics：
 * DFS、BFS、Union Find
 * <p>
 * https://www.cnblogs.com/grandyang/p/4402656.html
 * https://github.com/awangdev/LintCode/blob/master/Java/Number%20of%20Islands.java
 * http://wykvictor.github.io/2016/06/01/BFS-1.html
 *
 * @author li tong
 * @date 2019/6/17 18:28
 * @see Object
 * @since 1.0
 */
public class LeetCode_200_025 {

  public static void main(String[] args) {
    char[][] grid = new char[5][5];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        grid[i][j] = '0';
      }
    }
    init(grid);
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        System.out.print(grid[i][j]);
      }
      System.out.println();
    }
    System.out.println(numIslands(grid));
  }

  /**
   * [
   * [1, 1, 0, 0, 0],
   * [0, 1, 0, 0, 1],
   * [0, 0, 0, 1, 1],
   * [0, 0, 0, 0, 0],
   * [0, 0, 0, 0, 1]
   * ]
   * return 3.
   */
  public static int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length, n = grid[0].length, res = 0;
    boolean[][] visited = new boolean[m][n];
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (grid[i][j] == '0' || visited[i][j])
          continue;
        ++res;
        LinkedList<Integer> q = new LinkedList<>();
        q.push(i * n + j);
        bfs(q, grid, visited, m, n, dx, dy);
      }
    }
    return res;
  }

  private static void bfs(LinkedList<Integer> q, char[][] grid, boolean[][] visited, int m, int n, int[] dx, int[] dy) {
    while (!q.isEmpty()) {
      int t = q.peekFirst();
      q.pop();
      for (int k = 0; k < 4; ++k) {
        int x = t / n + dx[k], y = t % n + dy[k];
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0' || visited[x][y]) continue;
        visited[x][y] = true;
        q.push(x * n + y);
      }
    }
  }

  private static void dfs(char[][] grid, boolean[][] visited, int x, int y) {
    if (x < 0 || y < 0
            || x >= grid.length || y >= grid[0].length
            || grid[x][y] == '0' || visited[x][y]) {
      return;
    }
    visited[x][y] = true;
    // 上
    dfs(grid, visited, x - 1, y);
    // 下
    dfs(grid, visited, x + 1, y);
    // 左
    dfs(grid, visited, x, y - 1);
    // 右
    dfs(grid, visited, x, y + 1);
  }

  private static void init(char[][] board) {
    board[0][0] = '1';
    board[0][1] = '1';
    board[1][1] = '1';
    board[1][4] = '1';
    board[2][3] = '1';
    board[2][4] = '1';
    board[4][4] = '1';
  }

}

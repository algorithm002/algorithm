/*
 * @lc app=leetcode.cn id=200 lang=csharp
 *
 * [200] 岛屿数量
 */
using System.Collections;
using System.Collections.Generic;

public class Solution {
    // 解法1：DFS
    // char[][] m_g;
    // public int NumIslands (char[][] grid) {
    //     int nLands = 0;
    //     m_g = grid;
    //     for (int i = 0; i < m_g.Length; i++) {
    //         for (int j = 0; j < m_g[i].Length; j++) {
    //             if (m_g[i][j].Equals ('1'))
    //                 nLands += sink (i, j);
    //         }
    //     }
    //     return nLands;
    // }
    // public int sink (int i, int j) {
    //     if (i < 0 || i >= m_g.Length || j < 0 || j >= m_g[i].Length) {
    //         return 0;
    //     }
    //     if (m_g[i][j].Equals ('0')) {
    //         return 0;
    //     }
    //     m_g[i][j] = '0';
    //     sink (i + 1, j);
    //     sink (i - 1, j);
    //     sink (i, j + 1);
    //     sink (i, j - 1);
    //     return 1;
    // }

    // 解法2：BFS
    int[] dx = new int[] {-1, 1, 0, 0 };
    int[] dy = new int[] { 0, 0, -1, 1 };
    public int NumIslands (char[][] grid) {
        int nLands = 0;

        for (int i = 0; i < grid.Length; i++) {
            for (int j = 0; j < grid[i].Length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                nLands++;
                Queue que = new Queue ();
                que.Enqueue (new KeyValuePair<int, int> (i, j));
                while (que.Count > 0) {
                    KeyValuePair<int, int> kvp = (KeyValuePair<int, int>) que.Dequeue ();
                    if (grid[kvp.Key][kvp.Value] == '0') {
                        continue;
                    }
                    grid[kvp.Key][kvp.Value] = '0';
                    for (int k = 0; k < dx.Length; k++) {
                        int x = kvp.Key + dx[k], y = kvp.Value + dy[k];
                        if (x >= 0 && x < grid.Length && y >= 0 && y < grid[kvp.Key].Length && grid[x][y] == '1') {
                            que.Enqueue (new KeyValuePair<int, int> (x, y));
                        }
                    }
                }
            }
        }

        return nLands;
    }
}
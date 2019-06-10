package aleetcode.Largest_Rectangle_in_Histogram.DungeonGame;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }
        for(int i = 0; i <= n; i++) {
            dp[m][i] = Integer.MAX_VALUE;
        }
        dp[m][n-1] = 1;
        dp[m - 1][n] = 1;

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int minToNext = Math.min(dp[i][j + 1], dp[i+1][j]);

                if(dungeon[i][j] >= minToNext) {
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = minToNext - dungeon[i][j];
                }


            }
        }

        return dp[0][0];
    }
}

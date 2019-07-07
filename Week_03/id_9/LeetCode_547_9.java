package com.github.lifelab.leetcode.problemset;

/**
 * 朋友圈 @https://leetcode-cn.com/problems/friend-circles/
 *
 * @author Weichao Li (liweichao0102@gmail.com)
 * @since 2019-07-07
 */
public class Solution547 {


    public int findCircleNum(int[][] M) {
        //二维数组长度，即所有人的个数
        int length = M.length;
        //统计朋友圈个数
        int count = 0;
        //访问标志
        boolean[] flag = new boolean[length];
        //对于每个人
        for (int i = 0; i < length; i++) {
            //如果未被访问
            if (!flag[i]) {
                //深度优先搜索，访问
                dfs(i, M, flag);
                //朋友圈个数+1
                count++;
            }
        }
        return count;
    }

    /**
     * 深度优先搜索
     *
     * @param i    人的位置
     * @param M    朋友圈
     * @param flag 访问标识
     */
    public void dfs(int i, int[][] M, boolean[] flag) {
        //当前位占位
        flag[i] = true;

        for (int j = 0; j < M[i].length; j++) {

            if (!flag[j] && M[i][j] == 1) {
                dfs(j, M, flag);
            }
        }
    }
}

package id_1;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/20  12:44
 * @描述 LeetCode : 547. 朋友圈     https://leetcode-cn.com/problems/friend-circles/
 */
public class LeetCode_547_1 {

    public static void main(String[] args) {

    }

    /**
     * Method 1 : DFS 深度优先
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    count++;
                    dfs(M, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] m, int i, int j) {
        if (i < 0 || j < 0 || i >= m.length || j >= m.length || m[i][j] == 0) return;
        m[i][j] = 0;
        dfs(m, i + 1, j);
        dfs(m, i - 1, j);
        dfs(m, i, j + 1);
        dfs(m, i, j - 1);
    }
}

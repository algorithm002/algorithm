package id_1;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/19  14:48
 * @描述 LeetCode :  200. 岛屿数量       https://leetcode-cn.com/problems/number-of-islands/
 */
public class LeetCode_200_1 {

    public static void main(String[] args) {

        char[][] grid = new char[4][5];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '0';
        grid[0][3] = '0';
        grid[0][4] = '0';

        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[1][3] = '0';
        grid[1][4] = '0';

        grid[2][0] = '0';
        grid[2][1] = '0';
        grid[2][2] = '1';
        grid[2][3] = '0';
        grid[2][4] = '0';

        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '1';
        grid[3][4] = '1';
        final int i = new LeetCode_200_1().numIslands2(grid);
        System.out.println(i);
    }

    /**
     * Method 1 : 两层 循环 + DFS
     * 当前节点为 1 时，往 四周 感染为 1 的节点 变成 0；
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int num = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        // dfs 当前的四个方向
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    /**
     * Method 2 : Union Find 合并集
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : direction) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            int current = i * col + j;
                            int otherDirection = x * col + y;
                            unionFind.union(current, otherDirection);
                        }
                    }
                }
            }
        }
        return unionFind.count;
    }


    /**
     * Union find 类实现
     */
    class UnionFind {
        int count = 0;
        int[] father;
        int row, col;

        UnionFind(char[][] grid) {
            row = grid.length;
            col = grid[0].length;
            father = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        int temp = i * col + j;
                        father[temp] = temp;
                        count++;
                    }
                }
            }
        }

        /**
         * 合并方法
         */
        public void union(int node1, int node2) {
            int n1 = find(node1);
            int n2 = find(node2);
            if (n1 != n2) {
                father[n1] = n2;
                count--;
            }
        }

        /**
         * 查找方法
         */
        public int find(int node) {
            if (father[node] == node) return node;
            return find(father[node]);
        }
    }
}

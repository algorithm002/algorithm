/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */
class LeetCode_200_038 {
    /**
     * 染色
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        // check valid
        if(grid == null || grid.length == 0) return 0;
        
        int count = 0;
        int col = grid[0].length;
        int row = grid.length;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid);
                }
            }
        }

        return count;
    }

    public void bfs(int col, int row, char[][] grid) {
        if(col < 0 || col >= grid.length) return;
        if(row < 0 || row >= grid[0].length) return;
        if(grid[col][row] == '1') {
            grid[col][row] = '0';
            bfs(col + 1, row, grid);
            bfs(col, row + 1, grid);
            bfs(col - 1, row, grid);
            bfs(col, row - 1, grid);
        }
    }

    public static void main(String[] args) {
        LeetCode_200_038 testCode_200_038 = new LeetCode_200_038();
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, 
                                    {'1', '1', '0', '1', '0'}, 
                                    {'1', '1', '0', '0', '0'}, 
                                    {'0', '0', '0', '0', '0'}};
        System.out.println(testCode_200_038.numIslands(grid));
    }
}
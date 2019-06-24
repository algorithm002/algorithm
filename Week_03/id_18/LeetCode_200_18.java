package Week_03.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/17 10:17
 */
public class LeetCode_200_18 {
    private int rowNum;
    private int colNum;

    public int numIslands(char[][] grid) {
        int count = 0;
        rowNum = grid.length;
        if (rowNum == 0) {
            return 0;
        }
        colNum = grid[0].length;

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (grid[row][col] == '1') {
                    drown(grid, row, col);
                    count++;
                }
            }
        }

        return count;
    }

    private void drown(char[][] grid, int row, int col) {
        if (row < 0 || row >= rowNum || col < 0 || col>= colNum || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';
        drown(grid, row + 1, col);
        drown(grid, row, col + 1);
        drown(grid, row - 1, col);
        drown(grid, row, col - 1);
    }
}

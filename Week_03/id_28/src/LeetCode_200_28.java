package NumberOfIslands200;

public class Solution {
    int count=0;
    public int numIslands(char[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int i,int j,char[][] grid){
        if(i>=grid.length||i<0||j>=grid[0].length||j<0||grid[i][j]=='0'){
            return false;
        }

        grid[i][j]='0';
        boolean down=dfs(i+1,j,grid);
        boolean right=dfs(i,j+1,grid);
        boolean left=dfs(i,j-1,grid);
        boolean up=dfs(i-1,j,grid);
        return left&&right&&down&&up;

    }

    public static void main(String[] args) {
        //char[][] grid={{'1','1','0','0','0'}, {'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        //char[][] grid={{'1'},{'1'}};
        //char[][] grid={{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        char[][] grid={{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
        /*
        new LeetCode_174_28().dfs(0,0,grid);
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println("\n");
        }*/
        System.out.println(new Solution().numIslands(grid));
    }
}

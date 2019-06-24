public class Solution {
    boolean[][] visited;
    int res=0;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c = grid[i][j];
                if(c=='1'&&!visited[i][j]){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    //floodfill (i,j)
    private void dfs(char[][] grid, int i, int j) {
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int newi,newj;
            if(k==0){
                newi=i;newj=j-1;
            }else if(k==1){
                newi=i+1;newj=j;
            }else if(k==2){
                newi=i;newj=j+1;
            }else{
                newi=i-1;newj=j;
            }
            if(newi>=0&&newi<grid.length&&newj>=0&&newj<grid[0].length
            &&grid[newi][newj]=='1'&&!visited[newi][newj]){
                dfs(grid,newi,newj);
            }
        }
    }

    public static void main(String[] args) {
        char grid1[][] = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println((new Solution()).numIslands(grid1));
        // 1

        // ---

        char grid2[][] = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println((new Solution()).numIslands(grid2));
        // 3
    }
}
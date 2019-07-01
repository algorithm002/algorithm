/*
 * @lc app=leetcode id=200 lang=cpp
 *
 * [200] Number of Islands
 */

/*
class Solution {
public:
    
    int numIslands(const vector<vector<char>>& inputGrid) const {
        vector<vector<char>> grid = inputGrid;
        
        const int rows = grid.size();
        const int cols = rows ? grid[0].size() : 0;
        
        int islandCount = 0;
        
        stack<pair<int, int>> s;
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < cols; k++) {
                if (grid[j][k] == '1') {
                    islandCount++;
                    grid[j][k] = '0';
                    s.push({j, k});
                    while (!s.empty()) {
                        int m = s.top().first;
                        int n = s.top().second;
                        if (n + 1 < cols && grid[m][n + 1] == '1') {
                            grid[m][n + 1] = '0';
                            s.push({m, n + 1});
                        } else if (m + 1 < rows && grid[m + 1][n] == '1') {
                            grid[m + 1][n] = '0';
                            s.push({m + 1, n});
                        } else if (n - 1 >= 0 && grid[m][n - 1] == '1') {
                            grid[m][n - 1] = '0';
                            s.push({m, n - 1});
                        } else if (m - 1 >= 0 && grid[m - 1][n] == '1') {
                            grid[m - 1][n] = '0';
                            s.push({m - 1, n});
                        } else {
                            s.pop();
                        }
                    }
                }
            }
        }
        
        return islandCount;
        
    }
};
*/
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {

        int numTotal=0;
        for(int i=0; i<grid.size(); ++i) {
            for(int j=0; j<grid[i].size(); ++j) {
                if(grid[i][j]=='1') {
                    ++numTotal;
                    FloodFillIsland(grid,i,j);
                }
            }
        }
        return numTotal;
    }
    
    void FloodFillIsland(vector<vector<char>>& grid, int x, int y){

        if(x<0 || x>=grid.size() || 
           y < 0 || y >= grid[0].size())
            return;
        
        if(grid[x][y] != '1')
            return;
        grid[x][y]='0';

        FloodFillIsland(grid,x-1,y);
        FloodFillIsland(grid,x+1,y);
        FloodFillIsland(grid,x,y-1);
        FloodFillIsland(grid,x,y+1);
    }
};


class Solution {
public:
    vector<vector<bool>> visited;
	int dx[4] = { 1, -1, 0, 0 };
	int dy[4] = { 0, 0, 1, -1 };
	int numIslands(vector<vector<char>>& grid) {
		int numIslands = 0;
		for (int i = 0; i < grid.size(); ++i)
		{
			for (int j = 0; j < grid[i].size(); ++j)
			{
				if (grid[i][j] == '1')
				{
					dfsIslands(grid, i, j);
					++numIslands;
				}
			}
		}

		return numIslands;
	}

	void dfsIslands(vector<vector<char>>& grid, int x, int y)
	{
		if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size())  return;
		if (grid[x][y] == '0')  return;

		grid[x][y] = '0';
		for (int i = 0; i < 4; ++i)
		{
			dfsIslands(grid, x + dx[i], y + dy[i]);
		}
	}
};
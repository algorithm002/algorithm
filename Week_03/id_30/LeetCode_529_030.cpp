class Solution {
public:
    static const int DIRS = 8;
	int dx[DIRS] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int dy[DIRS] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	int GetMineCountAround(const vector<vector<char>>& board, int x, int y)
	{
		int mineCount = 0;
		for (int i = 0; i < DIRS; ++i)
		{
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx < 0 || xx >= board.size() || yy < 0 || yy >= board[0].size()) continue;
			if (board[xx][yy] == 'M')  ++mineCount;
		}
		return mineCount;
	}

	vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
		int x = click[0];
		int y = click[1];
		if (board[x][y] == 'M')
		{
			board[x][y] = 'X';
		}
		else
		{
			queue<pair<int, int>> que;
			que.push(make_pair(x, y));
			while (!que.empty())
			{
				pair<int, int> square = que.front();
				que.pop();
				int mineCount = GetMineCountAround(board, square.first, square.second);
				if (mineCount > 0)
				{
					board[square.first][square.second] = '0' + mineCount;
				}
				else
				{
					board[square.first][square.second] = 'B';
					for (int i = 0; i < DIRS; ++i)
					{
						int xx = square.first + dx[i];
						int yy = square.second + dy[i];
						if (xx < 0 || xx >= board.size() || yy < 0 || yy >= board[0].size()) continue;
						if (board[xx][yy] != 'E')  continue;
                        board[xx][yy] = 'W';
						que.push(make_pair(xx, yy));
					}
				}
			}
		}
		return board;
	}
};
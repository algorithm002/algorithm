/* BFS without visited.
 * T(n) = O(M*N) 遍历所有元素
 * S(n) = O(M*N) board的空间大小
 */
class Solution
{
public:
    vector<vector<char>> updateBoard(vector<vector<char>> &board, vector<int> &click)
    {
        rowMax = board.size();
        colMax = board[0].size();
        queue<pair<int, int>> q;
        if (board[click[0]][click[1]] == 'M')
        {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        q.push(make_pair(click[0], click[1]));

        while (!q.empty())
        {
            int n = q.size();
            for (int i = 0; i < n; i++)
            {
                pair<int, int> c = q.front();
                q.pop();
                if (board[c.first][c.second] == 'E')
                {
                    int count = getSurroundingMineCount(board, c.first, c.second);
                    if (count == 0)
                    {
                        board[c.first][c.second] = 'B';

                        for (int k = 0; k < 8; k++)
                        {
                            if (isInBoard(c.first + dx[k], c.second + dy[k])) 
                            {
                                q.push(make_pair(c.first + dx[k], c.second + dy[k]));
                            }
                        }
                    }
                    else
                    {
                        board[c.first][c.second] = '0' + count;
                    }
                }
            }
        }
        return board;
    }

    bool isInBoard(int row, int col)
    {
        return (row >= 0) && (row < rowMax) && (col >= 0) && (col < colMax);
    }

    int getSurroundingMineCount(vector<vector<char>> &board, int row, int col)
    {
        int count = 0;
        for (int k = 0; k < 8; k++)
        {
            int x = row + dx[k];
            int y = col + dy[k];
            if (isInBoard(row + dx[k], col + dy[k]))
                if (board[x][y] == 'M')
                    count++;
        }
        return count;
    }

private:
    int rowMax;
    int colMax;
    int dx[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int dy[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
};
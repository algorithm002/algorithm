class UnionFind
{
public:
    UnionFind(int n) : roots(n), rank(n, 0)
    {
        for (int i = 0; i < n; ++i)
        {
            roots[i] = i;
        }
    }

    bool uni(int p, int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return false;

        // use rank
        if (rank[pRoot] < rank[qRoot])
        {
            roots[pRoot] = qRoot;
        }
        else if (rank[pRoot] > rank[qRoot])
        {
            roots[qRoot] = pRoot;
        }
        else
        {
            roots[qRoot] = pRoot;
            rank[pRoot]++;
        }
        
        return true;
    }

    int find(int node)
    {
        if (roots[node] == node)
        {
            return node;
        }
        //path compression
        roots[node] = find(roots[node]);
        return roots[node];
    }

    bool connected(int p, int q)
    {
        return find(p) == find(q);
    }

private:
    vector<int> roots;
    vector<int> rank;
};

class Solution
{
public:
    int numIslands(vector<vector<char>> &grid)
    {
        if (grid.empty())
            return 0;

        // pruning: only search right/down.
        int dx[2] = {1, 0};
        int dy[2] = {0, 1};

        int m = grid.size();
        int n = grid[0].size();
        UnionFind uf(m * n);
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    count++;
                    for (int k = 0; k < 2; k++)
                    {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1')
                        {
                            int node1 = i * n + j;
                            int node2 = x * n + y;
                            if (uf.uni(node1, node2))
                                count--;
                        }
                    }
                }
            }
        }
        return count;
    }

private:
    int count = 0;
};

class Solution {
public:
    vector<int> parents;
	void unionSet(int i, int j)
	{
		while (parents[i] != i)  i = parents[i];
		while (parents[j] != j)
		{
			int p = parents[j];
			parents[j] = i;
			j = p;
		}
		parents[j] = i;
	}

	int findCircleNum(vector<vector<int>>& M) {
		const int N = M.size();
		for (int i = 0; i < N; ++i)
		{
			parents.push_back(i);
		}
		for (int i = 0; i < N - 1; ++i)
		{
			for (int j = i + 1; j < N; ++j)
			{
				if (M[i][j] == 1)  unionSet(i, j);
			}
		}
		unordered_set<int> circleSet;
		for (int i = 0; i < N; ++i)
		{
			int p = i;
			while (parents[p] != p)  p = parents[p];
			circleSet.insert(p);
		}
		return circleSet.size();
	}
};
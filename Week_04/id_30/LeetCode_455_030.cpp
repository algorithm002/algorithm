class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
		sort(s.begin(), s.end());
		int i = 0;
		for (int j = 0; i < g.size() && j < s.size(); ++j)
		{
			if (s[j] >= g[i])  ++i;
		}
		return i;
    }
};
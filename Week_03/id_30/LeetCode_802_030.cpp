class Solution {
public:
    bool dfsSaveNodes(const vector<vector<int>>& graph, vector<int>& visited, int curNode)
	{
		if (visited[curNode] > 0)  return visited[curNode] == 2;
		visited[curNode] = 1;
		for (int i = 0; i < graph[curNode].size(); ++i)
		{
			if (!dfsSaveNodes(graph, visited, graph[curNode][i])) return false;
			if(visited[curNode] == 2)  break;
		}
		visited[curNode] = 2;
		return true;
	}

	vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
		const int nodeCount = graph.size();
		vector<int> visited(nodeCount, 0);
		vector<int> safeNodes;
		for (int i = 0; i < nodeCount; ++i)
		{
			if (dfsSaveNodes(graph, visited, i))
			{
				safeNodes.push_back(i);
			}
		}
		return safeNodes;
	}
};
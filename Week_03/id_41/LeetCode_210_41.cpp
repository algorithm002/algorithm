/*
 * @lc app=leetcode id=210 lang=cpp
 *
 * [210] Course Schedule II
 * T(n) = O(V+E)
 * S(n) = O(V)
 */
class Solution
{
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites)
    {
        vector<vector<int>> vertex(numCourses);
        vector<int> indegrees(numCourses, 0);
        vector<int> topoOrder;
        queue<int> zeroQ;
        int count = 0;
        for (int i = 0; i < prerequisites.size(); i++)
        {
            int dst = prerequisites[i][0];
            int src = prerequisites[i][1];
            vertex[src].push_back(dst);
            indegrees[dst]++;
        }
        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0)
                zeroQ.push(i);
        while (!zeroQ.empty())
        {
            int current = zeroQ.front();
            zeroQ.pop();
            for (auto neighbor : vertex[current])
                if (--indegrees[neighbor] == 0)
                    zeroQ.push(neighbor);
            count++;
            topoOrder.push_back(current);
        }
        if (count == numCourses)
            return topoOrder;
        return {};
    }
};

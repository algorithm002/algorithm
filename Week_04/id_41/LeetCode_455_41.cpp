/*
 * @lc app=leetcode id=455 lang=cpp
 *
 * [455] Assign Cookies
 * Time complexity : O(min(g.size, s.size))
 * Space complexity: O(1)
 */
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int satisfied = 0;

        for (int j = 0; satisfied < g.size() && j < s.size(); j++)
        {
            if (g[satisfied] <= s[j])
            {
                satisfied++;
            }
        }
        return satisfied;
    }
};


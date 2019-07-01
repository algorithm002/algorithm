/*
 * @lc app=leetcode id=78 lang=cpp
 *
 * [78] Subsets
 */
// T(n) = O(N*2^N), S(n) = O(1)
class Solution_backtracing
{
public:
    vector<vector<int>> subsets(vector<int> &nums)
    {
        if (nums.size() == 0)
            return subs;
        dfs(nums, 0);
        return subs;
    }

private:
    vector<vector<int>> subs;
    vector<int> sub;
    void dfs(vector<int> &nums, int i)
    {
        // process current
        subs.push_back(sub);
        for (int j = i; j < nums.size(); j++)
        {
            sub.push_back(nums[j]);
            // drill down
            dfs(nums, j + 1);
            // restore
            sub.pop_back();
        }
    }
};

// bitops, T(n) = O(N*2^N), S(n) = O(1)
class Solution
{
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size();
        int p = 1 << n;
        vector<vector<int>> subs(p);

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j) & 1) {
                    subs[i].push_back(nums[j]);
                }
            }
        }
        return subs;
    }
};

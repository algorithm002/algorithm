/*
 * @lc app=leetcode id=198 lang=cpp
 *
 * [198] House Robber
 * TC : O(N)
 */
class Solution
{
public:
    int rob(vector<int> &nums)
    {
        int pre = 0;
        int cur = 0;
        for (auto n : nums)
        {
            int temp = max(pre + n, cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
};

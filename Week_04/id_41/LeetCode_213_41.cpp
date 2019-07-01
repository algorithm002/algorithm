/*
 * @lc app=leetcode id=213 lang=cpp
 *
 * [213] House Robber II
 * T(n) = O(N)
 * S(n) = O(1)
 */
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n < 2)
            return n ? nums[0] : 0;

        return max(robber(nums, 0, n - 2), robber(nums, 1, n - 1));
    }

private:
    int robber(vector<int>& nums, int l, int r)
    {
        int prev = 0;
        int curr = 0;
        int temp = 0;
        for (int i = l; i <= r; i++)
        {
            temp = max(prev + nums[i], curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
};

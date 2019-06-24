/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 * T(n) = O(N)
 * S(n) = O(N)
 */
class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        unordered_map<int, int> m;
        for (int i = 0; i < nums.size(); i++)
        {
            if (m.find(target - nums[i]) != m.end()) {
                return { m[target - nums[i]], i };
            }

            m[nums[i]] = i;
        }
        return {};
    }
};


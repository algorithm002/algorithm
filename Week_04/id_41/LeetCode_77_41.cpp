// T(n) = O(n!/k!(n-k)!))
class Solution
{
public:
    vector<vector<int>> combine(int n, int k)
    {
        if (n <= 0 or k <= 0 or n < k)
            return result;
        _combine(n, k, 1);
        return result;
    }

private:
    vector<vector<int>> result;
    vector<int> nums;
    void _combine(int n, int k, int start)
    {
        if (k == nums.size())
        {
            result.push_back(nums);
            return;
        }

        for (int i = start; i <= n - (k - nums.size()) + 1; ++i)
        {
            nums.push_back(i);
            _combine(n, k, i + 1);
            nums.pop_back();
        }
    }
};

class Solution {
public:
    vector<vector<int>> subsetsResult;

	vector<vector<int>> subsets(vector<int>& nums) {
		vector<int> result;
		permutateSubsets(nums, 0, result);
		return subsetsResult;
	}

	void permutateSubsets(vector<int>& nums, int i, vector<int>& result)
	{
		if (i >= nums.size())
		{
			subsetsResult.push_back(result);
			return;
		}
		permutateSubsets(nums, i + 1, result);
		result.push_back(nums[i]);
		permutateSubsets(nums, i + 1, result);
		result.pop_back();
	}
};
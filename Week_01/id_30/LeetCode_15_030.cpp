class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
    	vector<vector<int>> results;
		if (nums.size() < 3)  return results;
		sort(nums.begin(), nums.end());
		for (int i = 0; i <= nums.size() - 3; ++i)
		{
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			int j = i + 1, k = nums.size() - 1, target = -nums[i];
			while (j < k)
			{
				int sum = nums[j] + nums[k];
				if (sum < target)
				{
					++j;
					while (j < k && nums[j] == nums[j - 1])  ++j;
				}
				else if (sum > target)
				{
					--k;
					while (k > j && nums[k] == nums[k + 1])  --k;
				}
				else 
				{  
					vector<int> oneResult = { nums[i], nums[j], nums[k] };
					results.push_back(oneResult);
					++j; --k;
					while (j < k && nums[j] == nums[j - 1])  ++j;
					while (k > j && nums[k] == nums[k + 1])  --k;
				}
			}
		}
		return results;
	}
};
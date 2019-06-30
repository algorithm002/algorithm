class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
		int dp_i = 0, dp_pre_i = 0;
		for (int i = 0; i < n; ++i)
		{
			int cur_dp_i = dp_i;
			dp_i = max(dp_i, dp_pre_i + nums[i]);
			dp_pre_i = cur_dp_i;
		}
		return dp_i;
    }
};
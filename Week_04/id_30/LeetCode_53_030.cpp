class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if (nums.size() == 0)  return 0;
		int maxSum = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.size(); ++i)
		{
			sum = max(nums[i], sum + nums[i]);
			maxSum = max(sum, maxSum);
		}
		return maxSum;
    }
};
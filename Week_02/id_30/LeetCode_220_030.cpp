class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
		if (nums.size() <= 1)  return false;
		if (k <= 0 || t < 0)  return false;
		set<long long> kNums;
		kNums.insert(nums[0]);
		for (int i = 1; i < nums.size(); ++i)
		{
			set<long long>::iterator iter = kNums.lower_bound(static_cast<long long>(nums[i]) - t);
			if (iter != kNums.end() && abs(*iter - nums[i]) <= t)  return true;
			kNums.insert(nums[i]);
			if (kNums.size() == k + 1)
			{
				kNums.erase(nums[i - k]);
			}
		}
		return false;
	}
};
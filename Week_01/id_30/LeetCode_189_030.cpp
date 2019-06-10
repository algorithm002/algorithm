class Solution {
public:
    void reverseVector(vector<int>& nums, int i, int j)
	{
		while (i < j)
		{
			swap(nums[i++], nums[j--]);
		}
	}

	void rotate(vector<int>& nums, int k) {
		size_t n = nums.size();
		k %= n;
        if (k == 0)  return;
		reverseVector(nums, 0, n - k - 1);
		reverseVector(nums, n - k, n - 1);
		reverseVector(nums, 0, n - 1);
	}
};
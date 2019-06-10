class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int differentNumIndex = 0;
        for (int i = 1; i < nums.size(); ++i)
        {
            if (nums[i] != nums[i - 1])
            {
                nums[++differentNumIndex] = nums[i];
            }
        }
        return differentNumIndex + 1;
    }
};
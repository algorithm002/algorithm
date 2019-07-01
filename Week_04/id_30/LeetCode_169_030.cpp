class Solution {
public:
    int elementsCountInRange(vector<int>& nums, int beg, int end, int num)
    {
        int count = 0;
        for (int i = beg; i <= end; ++i)
        {
            if (nums[i] == num) ++count;
        }
        return count;
    }

    int majorityElementInRange(vector<int>& nums, int beg, int end)
    {
        if (beg == end)  return nums[beg];
        int mid = beg + (end - beg) / 2;
        int leftMajority = majorityElementInRange(nums, beg, mid);
        int rightMajority = majorityElementInRange(nums, mid + 1, end);
        if (leftMajority == rightMajority)  return leftMajority;
        int leftNum = elementsCountInRange(nums, beg, end, leftMajority);
        int rightNum = elementsCountInRange(nums, beg, end, rightMajority);
        return leftNum > rightNum ? leftMajority : rightMajority;
    }

    int majorityElement(vector<int>& nums) {
        return majorityElementInRange(nums, 0, nums.size() - 1);
    }
};
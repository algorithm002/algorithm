/*
 * @lc app=leetcode id=26 lang=cpp
 *
 * [26] Remove Duplicates from Sorted Array
 */
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        for (int j = 0; j < nums.size(); j++)
        {
            if (!i || nums[j] > nums[i-1])
            {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
};


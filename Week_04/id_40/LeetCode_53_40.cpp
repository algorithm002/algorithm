/*
 * @lc app=leetcode id=53 lang=cpp
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (43.84%)
 * Likes:    4476
 * Dislikes: 156
 * Total Accepted:    555.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
class Solution {
public:
/*
    //暴力解法
    int maxSubArray(vector<int>& nums) {
        if(nums.size()==0) return NULL;
        int max=nums[0];//存最大值 
        int sum=0;//求和
        for(int i=0;i<nums.size();i++)
        {
            sum=0;
            for(int j=i;j<nums.size();j++)
            {
                sum+=nums[j];
                if(sum>max) max=sum;
            }
        }
        return max;
    }
*/

    //动态规划
    int maxSubArray(vector<int>& nums) {
        if(nums.size() == 0) return NULL;
        int res = INT_MIN;
        int sum = -1;
        for(int i = 0; i < nums.size(); ++i)
        {
            sum = max(nums[i], sum + nums[i]);
            res = max(sum, res);
        }
        return res;
    }
 
};


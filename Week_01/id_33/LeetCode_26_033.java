/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int cur = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] != nums[cur]){
                cur++;
                nums[cur] = nums[i];
            }
        }
        return cur + 1;
    }
}


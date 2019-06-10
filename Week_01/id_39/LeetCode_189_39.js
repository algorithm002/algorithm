/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 * https://leetcode.com/problems/rotate-array/
 * 思路：比较难想，3次reverse
 * tips: 3种不同思路
 */
var reverse = function(nums, i, j) {
    while(i < j) {
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp
        i++;
        j--;
    }
}

var rotate = function(nums, k) {
    let len = nums.length;
    k %= len;
    
    reverse(nums, 0, len - k - 1);
    reverse(nums, len - k, len - 1);
    reverse(nums, 0, len - 1);
};
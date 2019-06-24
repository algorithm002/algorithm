/**
 * @param {number[]} nums
 * @return {number}
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 思路：对比前后两个数据，如果不相等，则把后面一个和起始第一个不重复位置的后一个交换
 */
var swap = function(arr, i, j) {
    let temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
var removeDuplicates = function(nums) {
    // 起始第一个不重复的点
    let notRepeat = 1;
    let max = nums[0];
    let i = 1;
    while(i < nums.length) {
        if (nums[i] !== nums[i-1] && nums[i] > max) {
            max = nums[i];
            swap(nums, notRepeat, i);
            notRepeat++
        }
        i++;
    }
    return notRepeat;
};
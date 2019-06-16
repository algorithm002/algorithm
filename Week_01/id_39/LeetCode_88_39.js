/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 * https://leetcode.com/problems/merge-sorted-array/
 */
var merge = function(nums1, m, nums2, n) {
    let last = m + n - 1;
    m--;
    n--;
    while (m >= 0 || n >= 0) {
        if (nums2[n] > nums1[m] || m < 0) {
            nums1[last--] = nums2[n--];
        } else {
            nums1[last--] = nums1[m--];
        }
    }
};
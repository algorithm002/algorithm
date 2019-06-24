/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 * https://leetcode.com/problems/merge-sorted-array/
 */
var merge = function(nums1, m, nums2, n) {
    var x = 0,
        y = 0;
    
    nums1.splice(m, nums1.length);
    nums2.splice(n, nums2.length);
    
    while(y < n){
        if(nums2[y] < nums1[x] || nums1[x] === undefined){
            nums1.splice(x, 0, nums2[y]);
            x++;
            y++;    
        } else {
            x++;
        }
    }
   // return nums1;
};

let nums1 = [2,0];
let m = 1;
let nums2 = [1];      
let n = 1;
merge(nums1, m, nums2, n);
console.log(nums1);

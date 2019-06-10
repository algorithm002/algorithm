/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    let i = 0
    while(i<k){        
        let num = nums.pop()
        nums.unshift(num)
        i++
    }      
    
};
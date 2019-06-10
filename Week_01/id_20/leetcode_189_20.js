/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.

 暴力解法  先删除 再添加 元素   循环操作
 */
var rotate = function(nums, k) {
    var len = nums.length;
    if(len<2){
        return;
    }
    if(k<0){
        return;
    }
    while(k--){
        nums.unshift(nums.pop());
    }
    return nums;

};

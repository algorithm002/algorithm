/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * https://leetcode.com/problems/two-sum/
 */
var twoSum = function(nums, target) {
    let hashTable = [];
    for (let i = 0; i < nums.length; i++) {
        let other = target - nums[i];
        if (hashTable[other] >= 0) {
            return [hashTable[other], i];
        };
        hashTable[nums[i]] = i;
    }
    return null;
};
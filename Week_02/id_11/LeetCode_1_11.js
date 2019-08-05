/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    
    let map = {}
    for(let i = nums.length - 1; i>=0; i--){
        let value = target - nums[i]
        if(map[value] != null){
            return [i, map[value]]
        }
        map[nums[i]] = i
    }

    return []
};


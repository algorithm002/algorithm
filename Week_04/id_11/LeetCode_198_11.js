/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    
    let _rob = []
    if(nums.length == 0){
        return 0
    }
    if(nums.length == 1){
        return nums[0]
    }
    if(nums.length == 2){
        return Math.max(nums[0], nums[1])
    }
    
    _rob[0] = nums[0]
    _rob[1] = Math.max(_rob[0], nums[1])
    for(let i = 2; i<nums.length; i++){        
        _rob[i] = Math.max(_rob[i-1], nums[i] + _rob[i-2])
    }
    
    return _rob.pop()
};
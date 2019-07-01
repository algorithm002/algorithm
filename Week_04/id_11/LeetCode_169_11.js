/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    
    if(nums.length == 1){
        return nums[0]
    }
    
    let maj = {}
    let majNum    
    nums.forEach(num => {
        if(maj[num] == null){
            maj[num] = 1
        }
        else{
            maj[num] = maj[num] + 1
            if(maj[num] > nums.length/2){
                majNum = num
                return
            }
        }
    })
    
    return majNum
    
};
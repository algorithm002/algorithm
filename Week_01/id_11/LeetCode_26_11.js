/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let len = nums.length
    let i = 0
    while(i<len){
        let num = nums.shift()
        if(num != nums[0]){
            nums.push(num)
        }
        i++
    }   
    
};
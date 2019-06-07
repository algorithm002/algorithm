/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if(nums.length==0) return nums;
    let start = 0; 
    for (let index = 0; index < nums.length; index++) {  
         if(nums[start]!=nums[index])
         {
             start++;
             nums[start] = nums[index]; 
         } 
    }  
     
     //return nums ;
    return start;
    
};

let nums=[1,1,2];
console.log(removeDuplicates(nums));


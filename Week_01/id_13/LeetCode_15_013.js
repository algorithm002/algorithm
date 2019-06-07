/**
 * @param {number[]} nums
 * @return {number[][]}
 * https://leetcode.com/problems/3sum/
 */
 
var threeSum = function(nums) { 
    if(nums.length < 3) return [];
    nums.sort(function(a,b){return a-b;});  
    let start= 0; 
    let result = new Map(); 
    while(nums.length-1>start+1)
    {
        let end = nums.length-1;
        let index = start+1;
        while(index<end)
        { 
            
            let sum = nums[start]+nums[index] + nums[end];
            if(sum == 0 )
            {
                let newArray = [nums[start],nums[index],nums[end]];
                result.set(newArray.join(''),newArray); 
                while(nums[index]==nums[index+1])
                {
                    index++;
                }
                index++;
                continue;
            }
            if(sum >0)
            {
                while(nums[end]==nums[end-1])
                    {
                        end --;
                    }
                end = end-1; 
            }
            else
            {
                while(nums[index]==nums[index+1])
                {
                    index++;
                }
                index++;
            }
        }  
       start = start+1; 
    }
    let resultArray = new Array(); 
    result.forEach(element => {
       resultArray.push(element);
        
    });
    
    return resultArray;
    
};

let  nums = [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6];
console.log(threeSum(nums));

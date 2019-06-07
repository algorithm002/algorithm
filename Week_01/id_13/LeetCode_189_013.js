//https://leetcode.com/problems/rotate-array/

var rotate = function(nums, k) {
    if(nums.length<2) return nums;
    if(k>0)
    {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    return nums;

}; 

function reverse(nums,start,end)
{
    if(!nums || !nums.length || start >=end) return  ;
    while (start<end) {
        let temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end --;
    }
    return nums;

}
let nums=[1,2,3,4,5,6,7];
let k = 3;
console.log(rotate(nums,k));

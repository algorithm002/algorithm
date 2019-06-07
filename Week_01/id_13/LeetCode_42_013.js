/**
 * @param {number[]} height
 * @return {number}
 * https://leetcode.com/problems/trapping-rain-water/
 */
var trap = function(height) {
    if (height.length<2) return 0; 
    let head = 0;
    let tail = head+1;
    let totalArea=0;
    let temp=0;
    while(tail<height.length)
    {  
        temp = temp+height[tail-1]; 
        if(height[tail]>height[head])
        {  
            let a= (tail-head) * height[head] - temp; 
            totalArea +=  a;
            temp=0; 
            head= tail; 
        }
        tail ++; 
    }  
    head = height.length-1;
    tail = head-1;
    temp = 0;
    while(tail >=0 )
    {
        temp = temp+height[tail+1];
        if(height[tail]>=height[head])
        { 
            let a= (head-tail)*height[head]-temp;
            totalArea +=  a;
            temp=0;
            head= tail;
        }
        tail --;
    }
    return totalArea;
};
 
let height=[2,0,2];
console.log(trap(height));

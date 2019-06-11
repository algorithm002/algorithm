//https://leetcode.com/problems/arranging-coins/
/**
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function(n) {
    if(n==0) return 0;
    if(n==1) return 1;
    let k =1 ;
    while(n>0 && n >=k)
    {
        n=n-k;
        k++;
    }
    return k-1;
    
};
let n = 8;

console.log(arrangeCoins(n));

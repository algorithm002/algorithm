/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */ 
 
var myPow = function(x, n) {
    if(n == 1) return x;
    if(n == 0) return 1;
    if(n < 0) return 1/myPow(x,-n);
    if(n%2==0)
    {
        let val= myPow(x,n/2);
        return val*val;
    }
    else
    {
        let val = myPow(x,(n-1)/2);
        return val*val*x;
    }
    
}
console.log(myPow(0.00001,2147483647));

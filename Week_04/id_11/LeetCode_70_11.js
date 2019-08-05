/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {



    if(n == 0) return 1
    if(n == 1) return 1

    let s = []
    s[0] = 1
    s[1] = 1
    for(let i = 2; i<= n; i++){
        s[i] = s[i-1] + s[i-2]
    }
    return s[n]
};



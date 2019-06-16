/**
 * @param {number} n
 * @return {number} 
 * 未使用二分查找
 * https://leetcode.com/problems/arranging-coins/
 */
var arrangeCoins = function(n) {
    let l = 1;
    let max = 0;
    while (true) {
        n = n - l;
        l++;
        if (n < 0) {
            break;
        }
        max++;
    }
    return max;
};

var arrangeCoins = function(n) {
    let l = 1;
    let max = 0;
    while (true) {
        n = n - l;
        l++;
        if (n < 0) {
            break;
        }
        max++;
    }
    return max;
};
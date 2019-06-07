/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 * https://leetcode.com/problems/powx-n/
 * 分治法（递归）， 不用递归的一种还没理解
 */
var myPow = function(x, n) {
    if (n === 0) {
        return 1;
    }
    if (n === 1) {
        return x;
    }
    if (n < 0) {
        return 1 / myPow(x, -n);
    }
    if (n % 2 === 1) {
        return x * myPow(x * x, (n - 1) / 2);
    }
    return myPow(x * x, n / 2);
};

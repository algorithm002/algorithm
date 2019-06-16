/*
 * @lc app=leetcode.cn id=441 lang=javascript
 *
 * [441] 排列硬币
 */
/**
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function (n) {
    if (n <= 1) {
        return n
    }
    let k = 1;
    while (n > 0) {
        n -= k;
        k++;
    }
    if (n == 0) {
        return k - 1;
    } else {
        return k - 2;
    }
};


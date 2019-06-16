/*
 * @lc app=leetcode.cn id=1047 lang=javascript
 *
 * [1047] 删除字符串中的所有相邻重复项
 */
/**
 * @param {string} S
 * @return {string}
 */
var removeDuplicates = function (S) {
    let stack = [];
    for (let i = 0; i < S.length; i++) {
        if (S[i] === stack[stack.length - 1]) {
            stack.pop();
        } else {
            stack.push(S[i])
        };
    }
    return stack.join('');
};


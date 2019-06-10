/**
 * @param {string} S
 * @return {string}
 * https://leetcode.com/problems/remove-outermost-parentheses/
 * 标志位，刨除标志位为0的时候，其余时候都移到结果中
 */
var removeOuterParentheses = function(S) {
    let sign = 0;
    let result = '';
    let i = 0;
    while (i < S.length) {
        let cur = S.charAt(i);
        if (cur === '(' && sign++ > 0) {
            result += cur;
        } else if (cur === ')' && sign-- > 1) {
            result += cur;
        }
        i++;
    }
    return result;
};

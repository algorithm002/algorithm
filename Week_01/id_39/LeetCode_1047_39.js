/**
 * @param {string} S
 * @return {string}
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
var removeDuplicates = function(S) {
    let arr = S.split('');
    let stack = [];
    for (let j = 0; j < arr.length; j++) {
        if (!stack.length) {
            stack.push(arr[j]);
            continue;
        }
        let prev = stack.pop();
        if (arr[j] !== prev) {
            stack.push(prev);
            stack.push(arr[j]);
        }
    }
    return stack.join('');
};
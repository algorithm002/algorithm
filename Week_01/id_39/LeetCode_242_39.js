/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 * https://leetcode.com/problems/valid-anagram/
 * 思路：一个map、len做加减，比较两个是否一样；
 * 也可以排序做（nLogN）
 */
var isAnagram = function(s, t) {
    let sArr = s.split('');
    let tArr = t.split('');
    let map = {};
    let len = 0;
    for (let i = 0; i < sArr.length; i++) {
        let cur = sArr[i];
        if (map[cur]) {
            map[cur] = map[cur] + 1;
        } else {
            map[cur] = 1;
            len++;
        }
    }
    for (let i = 0; i < tArr.length; i++) {
        let cur = tArr[i];
        if (map[cur]) {
            map[cur] = map[cur] - 1;
            if (map[cur] === 0) {
                len--;
            }
            if (map[cur] < 0) {
                return false;
            }
        } else {
            return false;
        }
    }
    return len === 0 ? true : false;
};

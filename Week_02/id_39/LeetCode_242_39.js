/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 * https://leetcode.com/problems/valid-anagram/
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }
    let sArr = s.split('');
    let tArr = t.split('');
    let map = {};
    
    for (let i = 0; i < sArr.length; i++) {
        if (!map[sArr[i]]) {
            map[sArr[i]] = 1;
        } else {
            map[sArr[i]]++;
        }
    }
    
    for (let i = 0; i < tArr.length; i++) {
        if (!map[tArr[i]] || map[tArr[i]] <= 0) {
            return false;
        }
        map[tArr[i]]--;
    }
    return true;
};
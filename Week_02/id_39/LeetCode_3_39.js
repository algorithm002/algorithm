/**
 * @param {string} s
 * @return {number}
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
var lengthOfLongestSubstring = function(s) {
    let sArr = s.split('');
    let max = 0;
    let map = {};
    let left = 0;
    for (let i = 0; i < sArr.length; i++) {
        if (map[sArr[i]] != null) {
            left = Math.max(left, map[sArr[i]] + 1);
        }
        map[sArr[i]] = i;
        max = Math.max(max, i - left + 1);
    }
        
    return max;
};
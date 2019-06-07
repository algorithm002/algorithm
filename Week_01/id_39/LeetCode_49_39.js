/**
 * @param {string[]} strs
 * @return {string[][]}
 * https://leetcode.com/problems/group-anagrams/
 * 空间换时间
 */
var groupAnagrams = function(strs) {
    let temp = {};
    let result = [];
    let groupId = 0;
    for (let i = 0; i < strs.length; i++) {
        let sorted = strs[i]
            .split('')
            .sort()
            .join('');
        if (!temp[sorted] && temp[sorted] != 0) {
            temp[sorted] = groupId;
            groupId++;
        }
        if (!result[temp[sorted]]) {
            result[temp[sorted]] = [];
        }
        result[temp[sorted]].push(strs[i]);
    }
    return result;
};

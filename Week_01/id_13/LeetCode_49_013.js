/**
 * @param {string[]} strs
 * @return {string[][]}
 * https://leetcode.com/problems/group-anagrams/
 */
var groupAnagrams = function(strs) { 
    let res = {};
    for (let str of strs) {
        let tmp = str.split('').sort().join('');
        (res[tmp] == null) ? res[tmp] = [str] : res[tmp].push(str); 
    }
    return Object.values(res);
};

let input= ["eat", "tea", "tan", "ate", "nat", "bat"];
console.log(groupAnagrams(input));

/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
    let json = {}
    for (var i = 0; i < s.length; i++) {
        json[s[i]] ? json[s[i]]++ : json[s[i]] = 1
    }
    for (var i = 0; i < t.length; i++) {
        if (json[t[i]]) {
            json[t[i]]--
        } else {
            return false
        }
    }
    let arr = Object.keys(json),
        len = arr.length;
    for (var i = 0; i < len; i++) {
        if (json[arr[i]] !== 0) {
            return false
        } else {
            if (i === len - 1) {
                return true
            }
        }
    }
    return true
};


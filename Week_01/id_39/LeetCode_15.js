/**
 * @param {number[]} nums
 * @return {number[][]}
 * https://leetcode.com/problems/3sum/
 * 备注：这一版太乱了， 内存性能都非常差！！！
 */

var threeSum = function(arrs) {
    if (arrs.length < 3) {
        return [];
    }
    let nums = [];
    let map = new Map();
    for (let i = 0; i < arrs.length; i++) {
        let cur = arrs[i];
        if (map.has(cur)) {
            let count = map.get(cur);
            if (count < 3) {
                map.set(cur, count + 1);
                nums.push(cur);
            }
        } else {
            map.set(cur, 1);
            nums.push(cur);
        }
    }
    // nums = temps;
    let result = new Set();
    for (let i = 0; i < nums.length; i++) {
        for (let j = 0; j < nums.length; j++) {
            let a = nums[i];
            let b = nums[j];
            let c = (-1) * (a + b);
            if (map.has(c)) {
                if ((a == b && b == c && c == a) && map.get(a) < 3) {
                    continue;
                }
                if ((a == b || a == c) && map.get(a) < 2) {
                    continue;
                }
                if (b == c && map.get(b) < 2) {
                    continue;
                }
                let arr = [a, b, c].sort().join(',');
                result.add(arr);
            }
        }
    }
    return Array.from(result, (val) => {
        return val.split(',')
    });
};
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
var zigzagLevelOrder = function(root) {
    if (!root) {
        return [];
    }
    let queue = [root];
    let isOdd = true;
    let levelNum = 1;
    let result = [];
    
    while (queue.length) {
        result.push([]);
        let level = result.length - 1;
        let count = 0;
        while (levelNum) {
            levelNum--;
            let node = queue.shift();
            if (node.val != null) {
                if (isOdd) {
                    result[level].push(node.val);
                } else {
                    result[level].unshift(node.val);
                }
            }
            if (node.left) {
                queue.push(node.left);
                count++;
            }
            if (node.right) {
                queue.push(node.right);
                count++;
            }
        }
        levelNum = count;
        isOdd = !isOdd;
    }
    
    return result;
};
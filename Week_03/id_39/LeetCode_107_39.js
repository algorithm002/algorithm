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
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
var levelOrderBottom = function(root) {
    if (!root) {
        return [];
    }
    let queue = [root];
    let levelNum = 1;
    let result = [];
    
    while (queue.length) {
        result.unshift([]);
        let count = 0;
        for (let i = 0; i < levelNum; i++) {
            let node = queue.shift();
            if (node.val != null) {
                result[0].push(node.val);
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
    }
    return result;
};
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
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
var levelOrder = function(root) {
    if (!root) {
        return [];
    }
    let result = [];
    let level = [root];
    let queue = [];
    let depth = -1;
    
    while (level.length) {
        result[++depth] = [];
        
        while (level.length) {
            let node = level.shift();
            
            if (node.val != null) {
                result[depth].push(node.val);
            }
            
            
            if (node.left) {
                queue.push(node.left);
            }
            if (node.right) {
                queue.push(node.right);
            }
        }
        
        level = queue;
        queue = [];
    }
    
    return result;
};
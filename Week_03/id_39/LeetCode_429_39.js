/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
var levelOrder = function(root) {
    if (!root) {
        return [];
    }
    let result = [];
    
    let queue = [];
    let level = [root];
    let depth = -1;
    
    while (level.length) {
        depth++;
        result[depth] = [];
        
        while (level.length) {
            let node = level.shift();
            result[depth].push(node.val);
            
            if (!node.children) {
                continue;
            }
            for (let i = 0; i < node.children.length; i++) {
                queue.push(node.children[i]);
            }
        }
        
        level = queue;
        queue = [];
    }
    return result;
};
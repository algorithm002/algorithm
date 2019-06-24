/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
// 广度优先搜索
var maxDepth = function(root) {
    if (!root) {
        return 0;
    }

    let queue = [];
    let level = [root];
    let depth = 0;

    while (level.length) {
        depth++;

        while (level.length) {
            let node = level.shift();
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

    return depth;
};

// DFS 深度优先搜索 递归形式
var maxDepth = function(root) {
    if (!root) {
        return 0;
    }
    return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
};

// DFS 深度优先搜索 非递归形式
var maxDepth = function(root) {
    if (!root) {
        return 0;
    }
};

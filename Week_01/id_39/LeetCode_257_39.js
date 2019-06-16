/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {string[]}
 * https://leetcode.com/problems/binary-tree-paths/submissions/
 */
var traverse = function(root, path, result) {
    if (!root.left && !root.right) {
        result.push(path + root.val);
        return;
    }
    path = path + root.val + '->';

    if (root.left) {
        traverse(root.left, path, result);
    }
    if (root.right) {
        traverse(root.right, path, result);
    }
};

var binaryTreePaths = function(root) {
    if (!root) {
        return [];
    }
    let result = [];
    traverse(root, '', result);
    return result;
};

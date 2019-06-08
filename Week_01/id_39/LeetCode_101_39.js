/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 * https://leetcode.com/problems/symmetric-tree/
 */

// 递归法
var treeSymmetric = function(t1, t2) {
    if (t1 == null || t2 == null) {
        return t1 == t2;
    }
    if (t1.val !== t2.val) {
        return false;
    }
    return treeSymmetric(t1.left, t2.right) && treeSymmetric(t1.right, t2.left);
};
var isSymmetric = function(root) {
    if (!root) {
        return true;
    }
    return treeSymmetric(root.left, root.right);
};


// 迭代法
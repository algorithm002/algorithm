
https://leetcode.com/problems/validate-binary-search-tree/
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
 */
var isValidBST = function(root) {
   const isValid = (root, low, high) => {
        if (!root) {return true}
        if (root.val <= low || root.val >= high) { return false }
        if (root.left && root.val <= root.left.val ) { return false }
        if (root.right && root.val >= root.right.val ) { return false }
        
        return isValid(root.left, Math.min(root.val, low), Math.min(root.val, high))
           && isValid(root.right, Math.max(root.val, low), Math.max(root.val, high))
    }
    return isValid(root, -Infinity, Infinity)
};


 
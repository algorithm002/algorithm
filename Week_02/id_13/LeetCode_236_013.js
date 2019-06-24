//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor= l= function(root, p, q) { 
    if(!root || root ==p || root == q) return root;
    let left = l(root.left,p,q);
    let right= l(root.right,p,q);
    if(!left) return right;
    if(!right) return left;
    return root;
};

 
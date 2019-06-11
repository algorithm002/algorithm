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
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
var lowestCommonAncestor = function(root, p, q) {
    if(!root || root == p || root == q  ) return root;  
    let leftNode = lowestCommonAncestor(root.left,p,q);
    let rightNode = lowestCommonAncestor(root.right,p,q);
    if (!leftNode) return rightNode;
    if(!rightNode) return leftNode;
    return root;     
    
};

 
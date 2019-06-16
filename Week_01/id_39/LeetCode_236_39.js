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

// 分别在左右子树查找p或者q，找到了就返回
var lowestCommonAncestor = function(root, p, q) {
    if (!root || root == p || root == q) {
        return root;
    }
    let left = lowestCommonAncestor(root.left, p, q);
    let right = lowestCommonAncestor(root.right, p, q);

    return left == null ? right : right == null ? left : root;
};

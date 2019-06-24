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
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 注意：最小深度是根节点到叶子节点，so 如果只有根节点和它都某一子节点，则深度为2
 */

var minDepth = function(root) {
    if (!root) {
        return 0;
    }
    let left = minDepth(root.left);
    let right = minDepth(root.right);
    if (left == 0 || right == 0) {
        return left + right + 1;
    }
    return Math.min(left, right) + 1;
};

/*
 * @lc app=leetcode.cn id=783 lang=javascript
 *
 * [783] 二叉搜索树结点最小距离
 */
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
 */
var minDiffInBST = function (root) {
    let prev = null;
    let min = Infinity;

    const inorder = curr => {
        if (!curr) return;

        inorder(curr.left);

        if (prev) {
            min = Math.min(min, Math.abs(curr.val - prev.val));
        }
        prev = curr;

        inorder(curr.right);
    };

    inorder(root);
    return min;
};


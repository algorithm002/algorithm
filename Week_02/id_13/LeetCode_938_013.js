//https://leetcode.com/problems/range-sum-of-bst/

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
var rangeSumBST = function(root, L, R) {
    if(!root) return 0;
    let sum = 0;
    let mid_s= function (root){
        if(!root) return;
        mid_s(root.left);
        if(root.val>=L && root.val <=R)
            {
                sum = sum+root.val;
            }
        mid_s(root.right);
    }
    mid_s(root);
    return sum ;
};
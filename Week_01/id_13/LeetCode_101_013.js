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
var isSymmetric = function(root) {
    
    if(!root) return root;
    
    let isMirror=   (left, right) => {
        if(!left &&  !right) return true;
        if(!left ||  !right) return false;
        return (( left.val === right.val)
          && isMirror(left.left,right.right)
          && isMirror(left.right, right.left)
        ) 
    } 
    return isMirror(root.left, root.right);
};


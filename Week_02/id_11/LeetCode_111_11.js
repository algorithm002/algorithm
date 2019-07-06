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
var minDepth = function(root) {
    if(root == null) return 0
    
    let left = minDepth(root.left)
    let right = minDepth(root.right)
    if(left == 0 || right == 0){
        return Math.max(left, right) + 1
    }
    else{
        return Math.min(left, right) + 1
    }    
};
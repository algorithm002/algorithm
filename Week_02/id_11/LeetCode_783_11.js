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

var minDiffInBST = function(root) {
    let pre
    let min = 100
    
    var inOrder = root => {
        if (root.left != null) inOrder(root.left);
        if (pre != null) min = Math.min(min, root.val - pre);
        pre = root.val;
        if (root.right != null) inOrder(root.right);
        return min; 
    }
    
    return inOrder(root)
};


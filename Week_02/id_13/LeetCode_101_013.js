//https://leetcode.com/problems/symmetric-tree/
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
var isSymmetric = function(root) {
  if(root==undefined) return root;
  let isMorror =(left,right)=>{
      if(left==undefined && right==undefined) return true;
      if(left==undefined || right == undefined) return false;
      return((left.val==right.val)
             && isMorror(left.left,right.right)
             && isMorror(left.right,right.left)
      )
      
  }  
  return isMorror(root.left,root.right);
  
};
  
 
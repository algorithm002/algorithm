//https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
    
    let depth= 0; 
    let mindepth= Infinity;
    if(!root) return 0;
    function _postorder(root)
    { 
        if(!root) return;
        if(root.left ==undefined && root.right== undefined )
            {
                mindepth= Math.min(depth,mindepth);
            }
        if(  root.left != undefined )
        { 
            depth++;  
             _postorder(root.left);  
            depth --;
         } 
        if(  root.right != undefined )
        { 
            depth++;  
             _postorder(root.right);  
            depth --;
         } 
         
          
    }
    _postorder(root);   
    return mindepth+1;
};
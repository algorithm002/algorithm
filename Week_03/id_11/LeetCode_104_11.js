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
var maxDepth = function(root) {
    let max = 0
    let level = 0

    dfs(root, level, max)
    return max  
};


var dfs = function(root, level, max){

    if(root == null) return
    if(level > max){
        max = level
    }   
    dfs(root.left, level + 1,  max)
    dfs(root.right, level + 1,  max)
}

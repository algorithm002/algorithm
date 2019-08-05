/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var zigzagLevelOrder = function(root) {

    let list = []
    let level = 0
    
    bfs(root, level, list)
    
    return list
};

var bfs = function(root, level, list){
    if(root == null) return 
    
    if(list[level] == null){
        list[level] = []
    }
    
    if((level & 1) != 0){
        list[level].push(root.val)
    }
    else{
        list[level].shift(root.val)
    }
    
    
    bfs(root.left, level + 1, list)
    bfs(root.right, level + 1, list)
}


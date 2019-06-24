//https://leetcode.com/problems/binary-tree-level-order-traversal/
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
var levelOrder = function(root) {
    if(!root || root.length==0) return [];
    let result = new Array(); 
    let queue = new Array();
    queue.push(root);
    while (queue.length>0) {
        let row = new Array();
        let len = queue.length;
        for (let i = 0; i < len; i++) { 
           /* let node = queue.shift();
            row.push(node.val);  
            if(node.left){queue.push(node.left);}
            if(node.right){queue.push(node.right);} 
            */
            row.push(queue[i].val);
            if(queue[i].left){queue.push(queue[i].left);}
            if(queue[i].right){queue.push(queue[i].right);} 
        } 
        queue= queue.slice(len); 
        result.push(row); 
    }
    return result;
};
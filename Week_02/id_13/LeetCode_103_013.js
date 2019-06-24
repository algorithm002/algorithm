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
    if(!root || root.length==0) return [] ;
    let queue= new Array();
    let result =new Array();
    queue.push(root);
    let zigzag=true; 
    while(queue.length)
    {
        let row= new Array();
        let len=queue.length;
        for (let i = 0; i < len; i++) 
        { 
            let node=null;
            if(zigzag)
            {
                node = queue.shift();
                if(node.left) queue.push(node.left);
                if(node.right) queue.push(node.right); 
            }
            else
            {
                node = queue.pop(); 
                if(node.right) queue.unshift(node.right);
                if(node.left) queue.unshift(node.left); 
            }
            row.push(node.val);
        } 
        result.push(row);
        zigzag=!zigzag; 
    } 
    return result;
    
};
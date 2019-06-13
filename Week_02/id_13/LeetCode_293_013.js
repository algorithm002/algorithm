//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    let result = new Array();
    if(!root) return result;
    let queue = new Array();
    queue.push(root)
    while(queue.length>0)
    {
        let node = queue.shift();
        if(node)
        {
            result.push(node.val);
            queue.push(node.left||null);
            queue.push(node.right||null);
        }
        else
        {
            result.push(null);
        }

    }
    while(result[result.length-1]==null){result.pop()}
    return JSON.stringify(result);
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    if(data.length==0) return null;
    let input =JSON.parse(data);
    let root = new TreeNode(input.shift());
    let currentNode  =null;
    let levelNodes = new Array();
    levelNodes.push(root);
    while(input.length>0)
    {
        let nextLevelNodes= new Array();  
        while(levelNodes.length>0)
        {
            currentNode =  levelNodes.shift();
            let leftNode = null;
            let rightNode = null;
            if(input.length > 0   )
            {
               leftNode  = new TreeNode(input.shift());
            } 
            if(input.length > 0 )
            {

                rightNode  = new TreeNode(input.shift());
            }
            if(leftNode && leftNode.val != null) 
            {
                currentNode.left=leftNode;
                nextLevelNodes.push(leftNode);
            }
            if(rightNode && rightNode.val != null)
            {
                currentNode.right=rightNode;
                nextLevelNodes.push(rightNode);
            }
            
           
        }
        
       levelNodes = nextLevelNodes;
        
    }
   // console.log(root);
    return root;
      
};
function TreeNode(val) {
     this.val = val;
     this.left = this.right = null;
 }
/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */

 let input= "[1,0,1]";
 let root = deserialize(input);
 let output = serialize(root);
 console.log(output);
 
 
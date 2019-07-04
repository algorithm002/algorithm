/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {

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
    
    list[level].push(root.val)
    
    root.children.forEach(child =>{        
        bfs(child, level + 1, list)
    })
}

let root = {"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}

console.log(levelOrder(root));

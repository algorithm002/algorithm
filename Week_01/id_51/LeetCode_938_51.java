/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int result = 0;
        if (root == null) return result;
        
        if (L < root.val) {
            result += rangeSumBST(root.left, L, R);              
        }
        if (root.val >= L && root.val <= R) {
            result += root.val;
        }
        if (R > root.val) {
            result += rangeSumBST(root.right, L, R);
        }
        
        return result;
    }
    
}

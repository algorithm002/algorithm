package validateBST98;

public class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inOrderVisit(root);
    }
    public boolean inOrderVisit(TreeNode root){
        if(root==null){
            return true;
        };
        boolean left_flag=inOrderVisit(root.left);
        if(left_flag==false){
            return false;
        }
        if(prev!=null&&prev.val>=root.val){
            return false;
        }
        this.prev=root;
        boolean right_flag=inOrderVisit(root.right);
        if(right_flag==false){
            return false;
        }
        return true;
    }
}

class Solution {
    private int min=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {

        dfs(root);
        return min;
    }

    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        int m=root.val;
        if(root.left!=null){
            int diff=m-root.left.val;
            if(diff<min){
                min=diff;
            }
            dfs(root.left);
        }
        if(root.right!=null){
            int diff=root.right.val-m;
            if(diff<min){
                min=diff;
            }
            dfs(root.right);
        }
    }
}
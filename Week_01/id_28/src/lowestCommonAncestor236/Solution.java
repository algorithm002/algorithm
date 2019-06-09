package lowestCommonAncestor236;

public class Solution {
    private TreeNode ret=null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(ret!=null){
            return ret;
        }
        return find(root,p,q);

    }
    /**
     * 定义子问题：如果发现的 p 或 q,则返回；负责返回 null。
     */
    public TreeNode find(TreeNode node, TreeNode p, TreeNode q) {

        if(ret==null){
            TreeNode left;
            TreeNode right;
            if (node==null||node==p||node==q)
                return node;
            left=find(node.left,p,q);
            right=find(node.right,p,q);


            if (left==null){
                return right;
            }else if (right==null){
                return left;
            }else {
                //ret=node;
                return node;
            }
        }
        return null;
    }

}

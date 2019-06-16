class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> ap=new ArrayList<>();
        List<TreeNode> aq=new ArrayList<>();
        findAncestors(root,p,ap);
        findAncestors(root,q,aq);
        TreeNode common=null;
        for(TreeNode a1:ap){
            for(TreeNode a2:aq){
                if(a1==a2){
                    common=a1;
                }
            }
        }
        return common;
    }

    public boolean findAncestors(TreeNode root,TreeNode target,List<TreeNode> ans){
        if(root==null){
            return false;
        }
        if(root==target){
            ans.add(root);
            return true;
        }

        ans.add(root);
        boolean leftFind=findAncestors(root.left,target,ans);
        if(!leftFind){
            ans.remove(root.left);
        }
        boolean rightFind=findAncestors(root.right,target,ans);
        if(!rightFind){
            ans.remove(root.right);
        }
        if(leftFind||rightFind){
            return true;
        }
        return false;

    }
}
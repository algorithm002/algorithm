package week01;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/10  16:38
 * @描述      LeetCode :  938. 二叉搜索树的范围和      https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumBst938 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(7);
        node.right.right = new TreeNode(18);
        System.out.println(new RangeSumBst938().rangeSumBST(node,7,15));
    }

    /**
     *  Method 1 : DFS  递归中直接操作数据
     *   时间复杂度 ： O(N)   ;   空间复杂度 ： O(N)    ;
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        return dfs(root,L,R);
    }

    private int dfs(TreeNode root, int l, int r) {
        if(root==null){
            return 0;
        }
        if(root.val<l ){
            return dfs(root.right,l,r);
        }
        if(root.val>r){
            return dfs(root.left,l,r);
        }
        return root.val+dfs(root.left,l,r)+dfs(root.right,l,r);
    }


}

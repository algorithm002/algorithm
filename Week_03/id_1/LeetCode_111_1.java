package id_1;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/21  12:58
 * @描述      LeetCode : 111. 二叉树的最小深度
 */
public class LeetCode_111_1 {

    /**
     *  Method 1: DFS
     */
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left==0 || right==0) return left+right+1;
        return Math.min(left,right)+1;
    }

    public static void main(String[] args) {

    }
}

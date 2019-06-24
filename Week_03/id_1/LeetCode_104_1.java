package id_1;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/21  12:53
 * @描述      LeetCode : 104. 二叉树的最大深度        https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class LeetCode_104_1 {

    public static void main(String[] args) {

    }

    /**
     *  Method 1 : DFS
     */
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

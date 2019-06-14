package week02;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/14  14:49
 * @描述 LeetCode : 236. 二叉树的最近公共祖先      https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorBinaryTree236 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);

        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);
        System.out.println(new LowestCommonAncestorBinaryTree236().lowestCommonAncestor(node, node.right, node.left).toString());
    }

    /**
     * Method 1 : 递归 ，从左右子树中分别查找
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(N)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}

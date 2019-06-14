package week02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/14  15:06
 * @描述 LeetCode : 101. 对称二叉树       https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree101 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        System.out.println(new SymmetricTree101().isSymmetric(node));
    }

    /**
     * Method 1 : BFS ，使用队列
     * 添加顺序：
     * 1、左子树的左
     * 2、右子树的右
     * 3、左子树的右
     * 4、右子树的左
     *  时间复杂度 : O(N)    ;
     *  空间复杂度 : O(N)    ;
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left==null && root.right==null)) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node2 = queue.poll();
            if (node == null && node2 == null) continue;
            if (node == null || node2 == null) return false;
            if (node.val != node2.val) return false;
            queue.offer(node.left);
            queue.offer(node2.right);
            queue.offer(node.right);
            queue.offer(node2.left);
        }
        return true;
    }

    /**
     * Method 2 : DFS
     *  时间复杂度 ： O(N)
     *  空间复杂度 ： O(N)
     */
    public boolean isSymmetric2(TreeNode root) {
        return isMirrer(root, root);
    }

    private boolean isMirrer(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) return true;
        if (root == null || root1 == null) return false;
        if (root.val != root1.val) return false;
        return isMirrer(root.left, root1.right) && isMirrer(root.right, root1.left);
    }

    /**
     * Method 2 : DFS      优化版
     *  时间复杂度 ： O(N)
     *  空间复杂度 ： O(N)
     */
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) return true;
        return isMirrer3(root.left, root.right);
    }

    private boolean isMirrer3(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && isMirrer3(left.left, right.right) && isMirrer3(left.right, right.left);
    }

}

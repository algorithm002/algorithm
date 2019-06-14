package week02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/13  12:27
 * @描述 LeetCode : 111. 二叉树的最小深度        https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 五毒神掌 ： 隔一周练习一次
 */
public class MinimunDepthBinaryTree111 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(6);
        System.out.println(new MinimunDepthBinaryTree111().minDepth3(node));
    }

    /**
     * Method 1 : DFS 递归解决
     * 时间复杂度 : O(N)    ;
     * 空间复杂度 ：  O(N)   ;
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? right + left + 1 : Math.min(left, right) + 1;
    }

    /**
     * Method 2 : 方法一  DFS 精简版
     * 时间复杂度 ： O(N)    ;
     * 空间复杂度 ： O(1); 没有额外的空间开销
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        return (root.left == null || root.right == null) ? minDepth(root.right) + minDepth(root.left) + 1 : Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * Method 3 : BFS 迭代   ；   使用队列 ; depth 记录深度；currentSize 记录当前层的数量； 只有数量为0时，当前层才算是深度加1；
     *  时间复杂度 : O(N)    ;
     *      *  空间复杂度 : O(N)    ;
     */
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1,currentSize = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (node.left == null && node.right == null) return depth;
            if (--currentSize == 0) {
                depth++;
                currentSize = queue.size();
            }
        }
        return depth;
    }

}

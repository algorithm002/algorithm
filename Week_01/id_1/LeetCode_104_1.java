package week01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/10  10:08
 * @描述 LeetCode : 104. 二叉树的最大深度    https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthBinaryTree104 {

    public static void main(String[] args) {

    }

    /**
     * Method 1: 递归  DFS —> 分别计算 左右节点的最大深度 ，比较 max ，然后加上 根节点 +1；
     * 时间复杂度： O(N) ；   空间复杂度： O(N)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * Method 2 : 迭代 BFS 的思想 ——> 用队列来存储 树的节点
     * 时间复杂度： O(N) 树的遍历 ;   空间复杂度：  O(N)  额外的空间：队列   ;
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            size--;
            if (size == 0) {
                depth++;
                size = queue.size();
            }
        }
        return depth;
    }

}

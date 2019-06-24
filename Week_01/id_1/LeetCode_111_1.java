package week01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/10  10:13
 * @描述      LeetCode :  111. 二叉树的最小深度   https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthBinaryTree111 {
    public static void main(String[] args) {
        final MinimumDepthBinaryTree111 tree111 = new MinimumDepthBinaryTree111();

    }

    /**
     * Method 1:  递归 分别求左右节点的最小深度；
     * 考虑情况 ：
     * 1： 左节点为空,只需要计算右节点的最小深度，即 right+1
     * 2： 右节点为空,只需要计算左节点的最小深度，即 left+1
     * 时间复杂度：O(N) ;   空间复杂度：O(N)
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int left = minDepth(root.left);
        final int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

    /**
     * Method 2 : 迭代 BFS 思想 —> 把 树的节点加入到 队列当中进行出来，当节点没有左节点和右节点时，返回当前深度即为最小深度
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (node.left == null && node.right == null) return depth;
            size--;
            if (size == 0) {
                depth++;
                size = queue.size();
            }
        }
        return depth;
    }
}

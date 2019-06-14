package week02;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/14  16:24
 * @描述 LeetCode : 102. 二叉树的层次遍历        https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelorderTraversal102 {
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
        final List<List<Integer>> list = new BinaryTreeLevelorderTraversal102().levelOrder(node);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    /**
     * Method 1 : BFS ，队列存储每一层的值, 用 currentSize 记录当前层的数量，currentSize 为0时，当前层遍历完毕
     *  时间复杂度 : O(N)  树的遍历  ;   空间复杂度 ： O(N)  ; 额外的空间 队列
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentSize = 1;
        List<Integer> currentList = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentList.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (--currentSize == 0) {
                currentSize = queue.size();
                list.add(currentList);
                currentList = new LinkedList<>();
            }
        }
        return list;
    }
}

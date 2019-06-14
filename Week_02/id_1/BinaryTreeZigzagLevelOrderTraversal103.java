package week02;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/14  16:41
 * @描述 LeetCode : 103. 二叉树的锯齿形层次遍历     https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {
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
        final List<List<Integer>> list = new BinaryTreeZigzagLevelOrderTraversal103().zigzagLevelOrder(node);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    /**
     *  Method 1 :  对 准备新插入 List<Integer>  进行处理，用一个奇偶数 或 布尔值 来记录是否需要反转
     *  时间复杂度 ： O(N)    树的遍历
     *  空间复杂度 : O(N)     额外空间 队列
     *
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentSize = 1;
        int depth =0;
        List<Integer> currentList = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentList.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (--currentSize == 0) {
                currentSize = queue.size();
                if(depth%2!=0) Collections.reverse(currentList);
                list.add(currentList);
                currentList = new LinkedList<>();
                depth++;
            }
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentSize = 1;
        boolean depth =false;
        List<Integer> currentList = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentList.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (--currentSize == 0) {
                currentSize = queue.size();
                if(depth) Collections.reverse(currentList);
                list.add(currentList);
                currentList = new LinkedList<>();
                depth=!depth;
            }
        }
        return list;
    }
}

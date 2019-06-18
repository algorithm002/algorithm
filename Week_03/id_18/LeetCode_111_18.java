package Week_03.id_18;

import java.util.Stack;

/**
 * @author LiveForExperience
 * @date 2019/6/12 21:50
 */
public class LeetCode_111_18 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int depth = Integer.MAX_VALUE;
        if (root.left != null) {
            depth = Math.min(minDepth(root.left), depth);
        }

        if (root.right != null) {
            depth = Math.min(minDepth(root.right), depth);
        }

        return depth + 1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        nodeStack.push(root);
        countStack.push(1);

        int min = Integer.MAX_VALUE;

        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            int count = countStack.pop();

            if (node.left == null && node.right == null) {
                min = Math.min(count, min);
            }

            if (node.left != null) {
                nodeStack.push(node.left);
                countStack.push(count + 1);
            }

            if (node.right != null) {
                nodeStack.push(node.right);
                countStack.push(count + 1);
            }
        }

        return min;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

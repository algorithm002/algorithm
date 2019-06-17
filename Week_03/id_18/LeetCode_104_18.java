package Week_03.id_18;

import java.util.Stack;

/**
 * @author LiveForExperience
 * @date 2019/6/17 18:03
 */
public class LeetCode_104_18 {
    public int maxDepth(TreeNode root) {
        return doSearch(0, root);
    }

    private int doSearch(int level, TreeNode root) {
        if (root == null) {
            return level;
        }

        level++;

        return Math.max(doSearch(level, root.left), doSearch(level, root.right));
    }

    private Stack<TreeNode> nodeStack = new Stack<>();
    private Stack<Integer> countStack = new Stack<>();

    public int maxDepth1(TreeNode root) {
        nodeStack.push(root);
        int max = 0;

        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            int count = countStack.pop();
            max = Math.max(max, count);

            drillDownAndCount(node.left, count);
            drillDownAndCount(node.right, count);
        }

        return max;
    }

    private void drillDownAndCount(TreeNode node, int count) {
        if (node != null) {
            nodeStack.push(node);
            countStack.push(count + 1);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

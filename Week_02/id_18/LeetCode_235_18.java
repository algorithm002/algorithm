package Week_02.id_18;

import java.util.Stack;

/**
 * @author LiveForExperience
 * @date 2019/6/14 18:30
 */
public class LeetCode_235_18 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (found(root, p, q)) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                if (found(node, p, q)) {
                    return node;
                }

                stack.push(node.left);
                stack.push(node.right);
            }
        }

        return null;
    }

    private boolean found(TreeNode node, TreeNode p, TreeNode q) {
        return p.val <= node.val && q.val >= node.val ||
                p.val >= node.val && q.val <= node.val;
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

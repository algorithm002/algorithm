package Week_01.id_18;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiveForExperience
 * @date 2019/6/10 18:52
 */
public class LeetCode_101_18 {
    public boolean isSymmetric(TreeNode root) {
        return doCheck(root, root);
    }

    private boolean doCheck(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null  || right == null) {
            return false;
        }

        return (left.val == right.val) && doCheck(left.left, right.right) && doCheck(left.right, right.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    private class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
}

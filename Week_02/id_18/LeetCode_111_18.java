package Week_02.id_18;

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

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

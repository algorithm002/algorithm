package Week_01.id_18;

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

    private class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
}

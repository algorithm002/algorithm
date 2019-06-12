package Week_02.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/12 12:49
 */
public class LeetCode_236_18 {
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        doRecurse(root, p, q);
        return result;
    }

    private boolean doRecurse(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) {
            return false;
        }

        int left = doRecurse(current.left, p, q) ? 1 : 0;
        int right = doRecurse(current.right, p, q) ? 1 : 0;
        int mid = current.val == p.val || current.val == q.val ? 1 : 0;

        if (mid + left + right >= 2) {
            result = current;
        }

        return mid + left + right > 0;
    }

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}

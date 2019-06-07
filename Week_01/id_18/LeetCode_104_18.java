package Week_01.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/7 18:56
 */
public class LeetCode_104_18 {
    public int maxDepth(TreeNode root) {
        return doSearch(0, root);
    }

    private int doSearch(int level, TreeNode root) {
        return root == null? level: Math.max(doSearch(++level, root.left), doSearch(level, root.right));
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


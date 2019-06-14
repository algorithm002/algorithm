package Week_02.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/14 13:27
 */
public class LeetCode_783_18 {
    public int minDiffInBST(TreeNode root) {
        return doSearch(root, null, null, Integer.MAX_VALUE);
    }

    private int doSearch(TreeNode root, TreeNode leftNode, TreeNode rightNode, int min) {
        if (root == null) {
            return min;
        }

        int left = leftNode == null ? Integer.MAX_VALUE : leftNode.val - root.val;
        int right = rightNode == null ? Integer.MAX_VALUE : root.val - rightNode.val;

        min = Math.min(Math.min(left, right), min);

        int leftChild = doSearch(root.left, root, rightNode, min);
        int rightChild = doSearch(root.right, leftNode, root, min);
        return Math.min(leftChild, rightChild);
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

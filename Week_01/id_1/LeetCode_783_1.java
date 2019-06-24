package week01;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/10  14:38
 * @描述 LeetCode : 783. 二叉搜索树结点最小距离     https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class MinimumdistanceBetweenBstNodes783 {

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        System.out.println(new MinimumdistanceBetweenBstNodes783().minDiffInBST(node));
    }

    /**
     *
     * Method 1 : 递归 中序遍历的方法；   先计算左边的相邻节点的最小差，在计算右边相邻节点的最小差
     *  时间复杂度 ： O(N)    ;   空间复杂度： O(1) ;
     */
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        // 终止条件
        if (root == null) return ;
        //要做的事情     // 先求 左边的两节点的最小差
        dfs(root.left);
        if (pre != null) min = Math.min(root.val - pre.val, min);
        pre = root;
        //要做的事情     // 先求 右边的两节点的最小差
        dfs(root.right);
    }

}

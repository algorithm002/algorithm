package week02;

import java.util.LinkedList;
import java.util.List;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/13  14:32
 * @描述 LeetCode : 783. 二叉搜索树结点最小距离     https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 五毒神掌 ：   练习上一周的习题
 */
public class MinimumDistanceBetweenBstNodes783 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        System.out.println(new MinimumDistanceBetweenBstNodes783().minDiffInBST(node));
    }

    /**
     * Method 1 :  中序遍历， 然后两两相减取最小值
     *  时间复杂度 ： O(2*N)  ;   中序遍历 + 循环
     *  空间复杂度 ： O(N)    ;   list 集合
     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void inOrder(TreeNode root, List list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    /**
     * Method 2 : 递归的方法 ，   用全局变量记忆存储上一个节点
     *  时间复杂度 ： O(N)
     *  空间复杂度 ： O(1)
     */
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int minDiffInBST2(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) min = Math.min(min, root.val - pre.val);
        pre = root;
        dfs(root.right);
    }

}

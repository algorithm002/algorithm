package week01;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/10  15:37
 * @描述 LeetCode : 257. 二叉树的所有路径        https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths257 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        System.out.println(new BinaryTreePaths257().binaryTreePaths(node));
    }

    /**
     * Method 1 : DFS  先左子树 ，再右子树
     * 时间复杂度 : O(N)  树的所有节点全部遍历一遍 ;   空间复杂度 ： O(N)    额外的开销 字符串
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list, "");
        return list;
    }

    private void dfs(TreeNode root, List list, String str) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(str += root.val);
            return;
        } else {
            dfs(root.left, list, str + root.val + "->");
            dfs(root.right, list, str + root.val + "->");
        }
    }
}

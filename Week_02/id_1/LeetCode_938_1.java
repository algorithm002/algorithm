package week02;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/14  17:54
 * @描述 LeetCode : 938. 二叉搜索树的范围和       https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumBst938 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(7);
        node.right.right = new TreeNode(18);
        System.out.println(new RangeSumBst938().rangeSumBST2(node, 7, 15));
    }

    /**
     * Method 1 :  中序遍历 ， 然后在 有序集合中 计算和 ；当前 值 大于 R ,直接break,避免无效的循环；
     *  时间复杂度 : O(N)    ;   中序遍历 + 循环
     *  空间复杂度 : O(N)    ;   list 集合
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (L <= list.get(i) && list.get(i) <= R)
                sum += list.get(i);
            if (list.get(i) > R) break;
        }
        return sum;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    /**
     * Method 2 : DFS  使用 二叉搜索树的特性， 在递归中操作；
     *  L 的值大于当前根节点的值时，从根的右子树中找
     *  R 的值小于当前根节点的值时，从根的左子树中找
     *  不然都要找
     *  时间复杂度 : O(N) ;
     *  空间复杂度 : O(N) ;
     */
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if(root==null) return 0;
        if(root.val<L) return rangeSumBST2(root.right,L,R);
        if(root.val>R) return rangeSumBST2(root.left,L,R);
        return root.val+rangeSumBST2(root.right,L,R)+rangeSumBST2(root.left,L,R);
    }

}

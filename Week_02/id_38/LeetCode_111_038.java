import java.util.*;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */
class LeetCode_111_038 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if ((root.l == null) && (root.r == null)) return 1;
        if (root.l == null) return minDepth(root.r) + 1;
        if (root.r == null) return minDepth(root.l) + 1;
        return Math.min(minDepth(root.l), minDepth(root.r)) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode l;
    TreeNode r;
    TreeNode(int x) {
        this.val = x;
    }
}


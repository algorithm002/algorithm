//The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
//
// Determine the maximum amount of money the thief can rob tonight without alerting the police.
//
// Example 1:
//
//
//Input: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \
//     3   1
//
//Output: 7
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//
// Example 2:
//
//
//Input: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \
// 1   3   1
//
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
package com.llz.algorithm.algorithm2019.fourthweek;

import apple.laf.JRSUIUtils;
import com.llz.algorithm.algorithm2019.firstweek.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class LeetCode_337_2 {


    /**
     * Easily get the DP equation as below.
     * Max(n) = Math.Max(Max(n-1), Max(n-2)+sum)
     * To minimise the space complexity by using two variables instead of one-dimensional array.
     * However, the solution is not right where get the [2,1,3,null,4] input.
     *
     * @param root
     * @return
     */
//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//        int pre = 0, prePre = 0, max = 0;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int sum = 0;
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                sum += node.val;
//                if (node.left != null)
//                    queue.offer(node.left);
//                if (node.right != null)
//                    queue.offer(node.right);
//            }
//            max = Math.max(pre, prePre + sum);
//            prePre = pre;
//            pre = max;
//        }
//        return max;
//    }

    /**
     * Referenced from discussion
     *
     * @param root
     * @return
     */
    public int robByRecursion(TreeNode root) {
        if (root == null)
            return 0;
        int val = 0;
        if (root.left != null)
            val += robByRecursion(root.left.left) + robByRecursion(root.left.right);
        if (root.right != null)
            val += robByRecursion(root.right.left) + robByRecursion(root.right.right);
        return Math.max(root.val + val, robByRecursion(root.left) + robByRecursion(root.right));
    }

    public int rob(TreeNode root) {
        // return robByRecurOptimised(root, new HashMap<TreeNode, Integer>());
        int[] res = robByDP(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robByDP(TreeNode root) {
        if (root == null) return new int[2];
        int[] res = new int[2]; //0:robbed; 1:not robbed
        int[] left = robByDP(root.left);
        int[] right = robByDP(root.right);
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }


    public int rob1(TreeNode root) {
        return robByRecurOptimised(root, new HashMap<TreeNode, Integer>());
    }

    /**
     * By using memo to reduce times of recursion.
     *
     * @param root
     * @param map
     * @return
     */
    public int robByRecurOptimised(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int val = 0;
        if (root.left != null)
            val += robByRecurOptimised(root.left.left, map) + robByRecurOptimised(root.left.right, map);
        if (root.right != null)
            val += robByRecurOptimised(root.right.left, map) + robByRecurOptimised(root.right.right, map);
        val = Math.max(root.val + val, robByRecurOptimised(root.left, map) + robByRecurOptimised(root.right, map));
        map.put(root, val);
        return val;
    }

    public static void main(String[] args) {
        /**
         *       2
         *     1   3
         *       4
         */

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        LeetCode_337_2 l = new LeetCode_337_2();
        System.out.println(l.rob(root));
    }
}

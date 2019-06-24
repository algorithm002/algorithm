package com.leecode.week03;

import com.leecode.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Leetcode_104_35 {
    public static void main(String[] args) {
        Leetcode_104_35 lc=new Leetcode_104_35();
        //int[] arr={3,2,9,-1,-1,10,-1,-1,8,-1,11,-1};
        //[3,9,20,null,null,15,7]
        int[] arr={3,9,20,-1,-1,-1,15,7};
       // int[] arr={3,2};
        TreeNode treeNode=TreeNode.createBinaryV1(arr,arr.length);
       int maxDept= lc.maxDepth(treeNode);
       System.out.println("maxDept->"+maxDept);
    }


    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }


}

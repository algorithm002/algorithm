package com.leecode.week03;

import com.geekbang.BinaryTree;
import com.leecode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 给定一个二叉树，找出其最小深度
 */
public class Leetcode_111_35 {
    public static void main(String[] args) {
        Leetcode_111_35 lc=new Leetcode_111_35();
        //int[] arr={3,2,9,-1,-1,10,-1,-1,8,-1,11,-1};
        //[3,9,20,null,null,15,7]
       int[] arr={3,9,20,-1,-1,-1,15,7};
      // int[] arr={3,2};
        TreeNode treeNode=TreeNode.createBinaryV1(arr,arr.length);
       int minDept= lc.minDepth(treeNode);
       System.out.println("minDepth->"+minDept);
    }


    /**
     * 思考过程:
     * 凡是要了解深度，都是要遍历到叶子节点，直接的想法就是遍历到所有的叶子节点，找到深度最小的那波即可
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if(root==null){
            return 0;
        }
        //当前的叶子节点的条件，左右都是null的
        if(root.left==null&&root.right==null){
            return 1;
        }
        int minDept=Integer.MAX_VALUE;
        if(root.left!=null){
            minDept=Math.min(minDepth(root.left),minDept);
        }

        if(root.right!=null){
            minDept=Math.min(minDepth(root.right),minDept);
        }

        //左右节点中不为空的情况，会往下递推一层，深度+1
        return minDept+1;
    }
}

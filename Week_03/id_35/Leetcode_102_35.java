package com.leecode.week03;

import com.leecode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class Leetcode_102_35 {
    public static void main(String[] args) {
        Leetcode_102_35 lc=new Leetcode_102_35();
        //int[] arr={3,2,9,-1,-1,10,-1,-1,8,-1,11,-1};
        //[3,9,20,null,null,15,7]
        int[] arr={3,9,20,-1,-1,-1,15,7};
       // int[] arr={3,2};
        TreeNode treeNode=TreeNode.createBinaryV1(arr,arr.length);

        List<List<Integer>>  list=  lc.levelOrder(treeNode);
        System.out.println(list);

    }

    /**
     * 思考过程，我是做了多叉树按层次遍历的题目之后来做这道题目的
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> queue=new ArrayDeque<>();
       queue.offer(root);

       while (!queue.isEmpty()){
           int queueSize=queue.size();
           List<Integer> ls =new ArrayList<>(queueSize);

           for(int i=0;i<queueSize;i++){
               TreeNode node =queue.poll();
               ls.add(node.val);
               if(node.left!=null){
                   queue.offer(node.left);

               }

               if(node.right!=null){
                   queue.offer(node.right);

               }

           }

           list.add(ls);
       }

        return list;
    }


}

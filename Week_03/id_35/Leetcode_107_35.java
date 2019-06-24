package com.leecode.week03;

import com.leecode.TreeNode;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 */

public class Leetcode_107_35 {

    public static void main(String[] args) {
        Leetcode_107_35 lc=new Leetcode_107_35();
        //int[] arr={3,2,9,-1,-1,10,-1,-1,8,-1,11,-1};
        //[3,9,20,null,null,15,7]
        int[] arr={3,9,20,-1,-1,-1,15,7};
        // int[] arr={3,2};
        TreeNode treeNode=TreeNode.createBinaryV1(arr,arr.length);

        List<List<Integer>>  list=  lc.levelOrderBottom(treeNode);
        System.out.println(list);

    }

    /**
     * 思考过程，我是做了多叉树按层次遍历的题目之后来做这道题目的
     * ,直接想法就是把结果反着输出就好了,要反着输出，就把结果压到栈上面
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Stack<List<Integer>> stack=new Stack<>();

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

            stack.push(ls);//结果压栈

        }


        //把结果挨个出栈
        while (!stack.empty()){
            List<Integer> ls =stack.pop();
            list.add(ls);
        }

        return list;
    }
}

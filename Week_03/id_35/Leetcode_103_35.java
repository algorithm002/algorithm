package com.leecode.week03;

import com.leecode.TreeNode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class Leetcode_103_35 {

    public static void main(String[] args) {
        Leetcode_103_35 lc=new Leetcode_103_35();
        //int[] arr={3,2,9,-1,-1,10,-1,-1,8,-1,11,-1};
        //[3,9,20,null,null,15,7]
        int[] arr={3,9,20,-1,-1,-1,15,7};
        // int[] arr={3,2};
        TreeNode treeNode=TreeNode.createBinaryV1(arr,arr.length);

        List<List<Integer>>  list=  lc.zigzagLevelOrder(treeNode);
        System.out.println(list);

    }

    /**
     * 思考过程，我是做了多叉树按层次遍历的题目之后来做这道题目的
     * ，同样在上面基础上面进行改进,要从左到右，然后从右到做，只要把每层加入的时候顺序往后或者往前就好了
     * 需要注意的是，出队列是有顺序的，所以只能是在写入list中元素的下标进行控制了
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        boolean needReverse=false;//false ->从左到右    true->从右到左

        while (!queue.isEmpty()){
            int queueSize=queue.size();
            Integer[] arr=new Integer[queueSize];

            for(int i=0;i<queueSize;i++){
                TreeNode node =queue.poll();


                if(needReverse){
                    System.out.println("queueSize:"+queueSize);
                    System.out.println("index:"+(queueSize-i-1));
                    arr[queueSize-i-1]=node.val;


                }else{
                    arr[i]=node.val;

                }

                if(node.left!=null){
                    queue.offer(node.left);

                }

                if(node.right!=null){
                    queue.offer(node.right);

                }

            }


            list.add(Arrays.asList(arr));
            needReverse=!needReverse;
        }

        return list;
    }
}

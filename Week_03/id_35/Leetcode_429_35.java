package com.leecode.week03;

import com.leecode.TreeNode;

import java.util.*;

/**
 *
 * N叉树的层序遍历
 */
public class Leetcode_429_35 {

     class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    public static void main(String[] args) {
        Leetcode_429_35 lc=new Leetcode_429_35();

        Node root=lc.createTree();



        List<List<Integer>>  list=  lc.levelOrder(root);
        System.out.println(list);

    }


    public Node createTree(){
        List<Node> _children56=new ArrayList<>();
        Node n5=new Node(5,null);
        Node n6=new Node(6,null);

        _children56.add(n5);
        _children56.add(n6);


        List<Node> _children324=new ArrayList<>();
        Node n3=new Node(3,_children56);
        Node n2=new Node(2,null);

        List<Node> _children78=new ArrayList<>();

        Node n7=new Node(7,null);
        Node n8=new Node(8,null);

        _children78.add(n7);
        _children78.add(n8);

        Node n4=new Node(4,_children78);



        _children324.add(n3);
        _children324.add(n2);
        _children324.add(n4);

        Node root=new Node(1,_children324);

        return root;




    }


    /**
     * 思考过程，按照层次遍历只是可以打印顺序，一开始是直接输出
     * 但是碰到有个问题的就是层次没注意，
     * 第一把提交未通过，再寻找原因
     *后面发现每次入队列的时候队列上面的元素其实就是当前层的顺序，但是这次需要每次取元素的时候把
     * 队列里面的元素都拿出来
     * 拿出来之后队列必然是空的，接下来就把下一层元素全部放进队列里面
     * 每个元素会被访问到两次，入队列一次，出队列一次
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<Node> queue=new ArrayDeque<>();
        queue.offer(root);


        while (!queue.isEmpty()){
            int curQueueSize=queue.size();
            List<Integer> ls=new ArrayList<>(curQueueSize);
            for (int i=0;i<curQueueSize;i++){
                Node node=queue.poll();
                ls.add(node.val);
                //孩子全部入队列
                if(node.children!=null&&node.children.size()!=0){
                    for(Node n:node.children){
                        queue.offer(n);
                    }
                }
            }

            list.add(ls);

        }


        return list;
    }







}

//Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
// For example, given a 3-ary tree:
//
//
//
//
//
//
//
// We should return its level order traversal:
//
//
//[
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// Note:
//
//
// The depth of the tree is at most 1000.
// The total number of nodes is at most 5000.
//
//

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

package com.llz.algorithm.algorithm2019.thirdweek;

import java.util.*;


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LeetCode_429_2 {

    /**
     * Time Complexity is O(n) and space complexity isO(n).(worst case)
     * if the tree is balanced, time and space complexity are both O(log3n).
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderByBFS(Node root) {
        List<List<Integer>> outterList = new ArrayList<>();
        if (root == null) return outterList;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> innerList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                innerList.add(cur.val);
                List<Node> children = cur.children;
                for (int j = 0; j < children.size(); j++) {
                    queue.add(children.get(j));
                }
            }
            outterList.add(innerList);
        }
        return outterList;
    }

    public List<List<Integer>> levelOrderByDFS(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    public void dfs(Node cur, List<List<Integer>> list, int level) {
        if (cur == null) return;
        List<Integer> innerList = new ArrayList<>();
        if (list.size() > level)
            innerList = list.get(level);
        innerList.add(cur.val);
        if (list.size() <= level)
            list.add(innerList);
        for (Node node : cur.children) {
            dfs(node, list, level + 1);
        }
    }

    public static void main(String[] args) {
        List children1 = new ArrayList(Arrays.asList(new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>())));
        Node c1 = new Node(2, children1);
        List children0 = new ArrayList(Arrays.asList(c1, new Node(3, new ArrayList<>()), new Node(4, new ArrayList<>())));
        Node root = new Node(1, children0);
        LeetCode_429_2 l = new LeetCode_429_2();
        List<List<Integer>> list=l.levelOrderByDFS(root);
        System.out.println(list);
    }
}

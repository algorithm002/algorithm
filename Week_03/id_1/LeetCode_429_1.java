package id_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/19  12:25
 * @描述      LeetCode : 429. N叉树的层序遍历    https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/submissions/
 */

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class LeetCode_429_1 {

    public static void main(String[] args) {
        final Node node5 = new Node(5, null);
        final Node node6 = new Node(6, null);
        final LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(node5);
        nodes.add(node6);
        final Node node3 = new Node(3, nodes);
        final Node node2 = new Node(2, null);
        final Node node4 = new Node(4, null);
        final LinkedList<Node> nodes2 = new LinkedList<>();
        nodes2.add(node3);
        nodes2.add(node2);
        nodes2.add(node4);
        final Node root = new Node(1, nodes2);
        final List<List<Integer>> lists = new LeetCode_429_1().levelOrder2(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }

    }

    /**
     * Method 1 : BFS 队列实现
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(N)
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;

        Queue<Node> queue = new LinkedList<>();
        List<Integer> linkedList = new LinkedList<>();
        queue.offer(root);
        int currentSize = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            linkedList.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            if (--currentSize == 0) {
                currentSize = queue.size();
                list.add(linkedList);
                linkedList = new LinkedList<>();
            }
        }
        return list;
    }

    /**
     *   Method 2 :  BFS 不在外层创建 临时的 List<Integer> , 在循环内部创建
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> linkedList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                linkedList.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            list.add(linkedList);
        }
        return list;
    }

    public List<List<Integer>> levelOrder3(Node root) {
        List<List<Integer>> ret = new LinkedList<>();

        if (root == null) return ret;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }

        return ret;
    }

}


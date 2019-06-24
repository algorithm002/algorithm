package Week_03.id_18;

import java.util.*;

/**
 * @author LiveForExperience
 * @date 2019/6/18 12:53
 */
public class LeetCode_429_18 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> levelNodeVals = new ArrayList<>(count);
            while (count-- > 0) {
                Node node = queue.poll();
                levelNodeVals.add(node.val);
                for (Node childNode: node.children) {
                    queue.offer(childNode);
                }
            }

            result.add(levelNodeVals);
        }

        return result;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

package Week_03.id_18;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiveForExperience
 * @date 2019/6/21 13:18
 */
public class LeetCode_102_18 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> nodeLevel = new ArrayList<>();

            while (count-- > 0) {
                TreeNode node = queue.poll();
                nodeLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(nodeLevel);
        }

        return result;
    }

    private List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return levels;
        }

        dfs(root, 0);
        return levels;
    }

    private void dfs(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);

        if (node.left != null) {
            dfs(node.left, level + 1);
        }

        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

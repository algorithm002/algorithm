package Week_02.id_18;

import java.util.*;

/**
 * @author LiveForExperience
 * @date 2019/6/12 12:49
 */
public class LeetCode_236_18 {
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        doRecurse(root, p, q);
        return result;
    }

    private boolean doRecurse(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) {
            return false;
        }

        int left = doRecurse(current.left, p, q) ? 1 : 0;
        int right = doRecurse(current.right, p, q) ? 1 : 0;
        int mid = current.val == p.val || current.val == q.val ? 1 : 0;

        if (mid + left + right >= 2) {
            result = current;
        }

        return mid + left + right > 0;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        stack.push(root);
        parents.put(root, null);

        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode current = stack.pop();

            if (current.left != null) {
                stack.push(current.left);
                parents.put(current.left, current);
            }

            if (current.right != null) {
                stack.push(current.right);
                parents.put(current.right, current);
            }
        }

        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parents.get(p);
        }

        while (!pAncestors.contains(q)) {
            q = parents.get(q);
        }

        return q;
    }

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}

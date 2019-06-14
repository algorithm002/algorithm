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

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;

        boolean oneFound = false;

        Stack<Object[]> stack = new Stack<>();

        stack.push(new Object[]{root, 2});

        TreeNode childNode = null;

        while (!stack.isEmpty()) {
            Object[] parentArr = stack.peek();
            if (parentArr[0] == null) {return p;}
            TreeNode parentNode = (TreeNode) parentArr[0];
            int parentState = (int) parentArr[1];
            if (parentState != 0) {
                if (parentState == 2) {
                    if (parentNode == p || parentNode == q) {
                        if (oneFound) {
                            return lca;
                        } else {
                            lca = (TreeNode)stack.peek()[0];
                            oneFound = true;
                        }
                    }
                    childNode = parentNode.left;
                } else {
                    childNode = parentNode.right;
                }

                stack.pop();
                stack.push(new Object[]{parentNode, parentState - 1});

                if (childNode != null) {
                    stack.push(new Object[]{childNode, 2});
                }
            } else {
                if (stack.pop()[0] == lca && oneFound) {
                    lca = (TreeNode) stack.peek()[0];
                }
            }
        }
        return lca;
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

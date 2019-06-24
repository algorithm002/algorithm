package week01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/10  11:47
 * @描述      LeetCode : 101. 对称二叉树   https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree101 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(2);
        node.left.left=new TreeNode(3);
        node.left.right=new TreeNode(4);
        node.right.left=new TreeNode(4);
        node.right.right=new TreeNode(4);
        System.out.println(new SymmetricTree101().isSymmetric2(node));
    }

    /**
     *  Method 1 : 迭代 BFS —> 把每一层的节点都放在队列中，树的左子树 和 右子树 比较是否相等；
     *  时间复杂度 ： O(N) 树的节点  ；    空间复杂度 ： O(N) 额外的空间队列；
     *
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        nodes.offer(root);
        while (!nodes.isEmpty()){
             TreeNode n1 = nodes.poll();
             TreeNode n2 = nodes.poll();
             if(n1 ==null && n2==null) continue;
             if(n1==null || n2 ==null) return false;
             if(n1.val!=n2.val) return false;
            nodes.offer(n1.left);
            nodes.offer(n2.right);
            nodes.offer(n1.right);
            nodes.offer(n2.left);
        }
        return true;
    }

    /**
     *  Method 2 : 递归 DFS —>    操作同一棵树两次，树的左子树 和 右子树 比较；
     *  时间复杂度 ： O(N)    ；   空间复杂度 ： O(N)    ；
     */
    public boolean isSymmetric2(TreeNode root) {
        return isMirrer(root,root);
    }

    private boolean isMirrer(TreeNode n1,TreeNode n2) {
        if(n1==null&& n2==null) return true;
        if(n1==null || n2==null) return false;
        if(n1.val!=n2.val)  return false;
        return isMirrer(n1.left,n2.right)&& isMirrer(n1.right,n2.left);
    }
}

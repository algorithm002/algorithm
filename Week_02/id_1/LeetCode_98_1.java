package week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/12  17:45
 * @描述      LeetCode : 98. 验证二叉搜索树      https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
//        TreeNode node = new TreeNode(5);
//        node.left = new TreeNode(1);
//        node.right = new TreeNode(4);
//        node.right.left = new TreeNode(3);
//        node.right.right = new TreeNode(6);

        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(6);
        node.right.left = new TreeNode(11);
        node.right.right = new TreeNode(20);

//        TreeNode node = new TreeNode(0);
//        node.left = new TreeNode(-1);

//        TreeNode node = new TreeNode(6);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(8);
//        node.left.left = new TreeNode(0);
//        node.left.right = new TreeNode(4);
//        node.left.right.left = new TreeNode(3);
//        node.left.right.right = new TreeNode(5);
//        node.right.left = new TreeNode(7);
//        node.right.right = new TreeNode(9);
        System.out.println(new ValidateBinarySearchTree98().inorderTraversal(node));
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }
    /**
     *  Method 1 : 中序遍历 为 升序    ;   不满足条件 即返回 false
     *  时间复杂度 : O(N)
     *  空间复杂度 : O(N)
     **/
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        List<Integer> list = new LinkedList<Integer>();
        inOrder(root,list);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }

    private void inOrder(TreeNode root,List list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }


}

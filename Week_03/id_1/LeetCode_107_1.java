package id_1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/19  13:13
 * @描述      LeetCode : 107. 二叉树的层次遍历 II     https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LeetCode_107_1 {

    /**
     *  Method 1 : BFS 一套标准的 BFS 代码模板解决多类问题
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> linkedList = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                linkedList.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            list.add(linkedList);
        }
        Collections.reverse(list);
        return list;
    }
}

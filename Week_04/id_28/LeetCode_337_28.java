import levelTravel429.Node;

import java.util.*;

public class LeetCode_337_28 {



    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        Map<TreeNode,Integer> map=new HashMap<TreeNode,Integer>();
        return dp(root,map);

    }

    public Integer dp(TreeNode node,Map<TreeNode,Integer> map){
        if (node==null){
            return 0;
        }
        if(!map.containsKey(node) ){
            int left=dp(node.left,map);
            int right=dp(node.right,map);
            int left_left=(node.left==null? 0:dp(node.left.left,map));
            int left_right=(node.left==null? 0:dp(node.left.right,map));
            int right_left=(node.right==null? 0:dp(node.right.left,map));
            int right_right=(node.right==null? 0:dp(node.right.right,map));
            map.put(node,Math.max(Math.max(Math.max(left+right,
                    (node.left==null? 0:node.left.val)+right_left+right_right),
                    (node.right==null? 0:node.right.val)+left_left+left_right),
                    node.val+left_left+left_right+right_left+right_right));
        }
        System.out.println(map.get(node));
        return map.get(node);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        System.out.println(new LeetCode_337_28().rob(root));
    }
}

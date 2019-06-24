import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};



public class leetCode_429_42 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            List<Integer> temp=new ArrayList<>();
            Node curNode=null;
            for(int i=0;i<len;i++){
                curNode=queue.poll();
                temp.add(curNode.val);
                if(curNode.children!=null){
                    for(Node node:curNode.children){
                        queue.offer(node);
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }


}

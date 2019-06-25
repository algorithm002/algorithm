package levelTravel429;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> queue=new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        List<List<Integer>> ret=new LinkedList<List<Integer>>();
        List<Integer> list=new LinkedList<Integer>();
        while (queue.size()>0){
            Node e=queue.pop();

            if(e!=null){
                list.add(e.val);
                if(e.children!=null&&e.children.size()>0){
                    for (Node chi:e.children){
                        if(chi!=null){
                            queue.addAll(e.children);
                        }
                    }

                }

            }else {

                ret.add(list);
                list=new LinkedList<Integer>();

            }
        }
        return ret;

    }

    public static void main(String[] args) {

    }

}

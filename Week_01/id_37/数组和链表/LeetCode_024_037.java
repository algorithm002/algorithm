public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        ListNode p=dummyNode;
        while(p.next!=null&&p.next.next!=null){
            ListNode node1=p.next;
            ListNode node2=node1.next;
            ListNode next=node2.next;
            node2.next=node1;
            node1.next=next;
            p.next=node2;
            p=node1;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        ListNode list=new ListNode(nums);
        System.out.println(list.toString());
        ListNode listNode = new Solution().swapPairs(list);
        System.out.println(listNode.toString());
    }
}
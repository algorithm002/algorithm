class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode l3=new ListNode(0);
        ListNode cur3=l3;
        while(cur1!=null||cur2!=null){
            if(cur1==null){
                cur3.next=new ListNode(cur2.val);
                cur3=cur3.next;
                cur2=cur2.next;
                continue;
            }
            if(cur2==null){
                cur3.next=new ListNode(cur1.val);
                cur3=cur3.next;
                cur1=cur1.next;
                continue;
            }

            if(cur1.val<=cur2.val){
                cur3.next=new ListNode(cur1.val);
                cur3=cur3.next;
                cur1=cur1.next;

            }else{
                cur3.next=new ListNode(cur2.val);
                cur3=cur3.next;
                cur2=cur2.next;
            }
        }
        return l3.next;
    }
}
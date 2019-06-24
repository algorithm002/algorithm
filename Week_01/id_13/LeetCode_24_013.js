//https://leetcode.com/problems/swap-nodes-in-pairs/

var swapPairs = function(head) {
    if(!head || !head.next) return head;
    let dummy = new ListNode(0);
    dummy.next = head;
    let current = dummy;
    while (current.next && current.next.next)
    {
        let n = current.next;
        let nn =  current.next.next;
        current.next.next =  current.next.next.next;
        current.next = nn;
        current.next.next=n;
        current = current.next.next
            
    }
    return dummy.next; 
};
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
var mergeTwoLists = function(l1, l2) {
    if(!l2) return l1;
    if(!l1) return l2;
    if(!l1 || !l2) return ;
    let head = new ListNode(0);
    let l = head;
    while(l1)
    { 
        if(!l2)
        {
            l.next= l1;
            break;
        }
        if(l1.val <= l2.val)
        {  
            l.next = l1;
            l1=l1.next;
        }
        else
        {  
            l.next=l2;
            l2=l2.next;
        }
        l= l.next;
    }
    if(l2)
    {
       
        l.next = l2;
    }
    return head.next;
};
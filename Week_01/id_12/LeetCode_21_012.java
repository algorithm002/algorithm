//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
// Example:
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
//
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null || l2 == null)
        {
            return l1 == null ? l2 : l1;
        }
        ListNode temp = l1.val < l2.val ? l1 : l2;
        temp.next = mergeTwoLists(temp.next, temp == l1 ? l2 : l1);
        return temp;
    }
}
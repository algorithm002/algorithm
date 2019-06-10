//Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//
//
// Example:
//
//
//Given 1->2->3->4, you should return the list as 2->1->4->3.
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

    private boolean flag = true;

    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode start = head.next;
        recursion(head, null, null);
        return start;
    }

    private void recursion(ListNode node, ListNode pre1, ListNode pre2)
    {
        if (node == null)
        {
            return;
        }
        flag = !flag;
        if (flag)
        {
            pre1.next = node.next;
            node.next = pre1;
            if (pre2 != null)
            {
                pre2.next = node;
            }
            recursion(pre1.next, pre1, node);
        }
        else
        {
            recursion(node.next, node, pre1);
        }
    }
}
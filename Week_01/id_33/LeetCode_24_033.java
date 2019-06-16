/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        pre.next = head;
        ListNode tmp = pre;
        while(cur != null){
            ListNode next = cur.next;
            if(next != null){
                cur.next = next.next;
                next.next = cur;
                pre.next = next;
                pre = cur;
                cur = cur.next;
            } else 
                break;
        }
        return tmp.next;
    }
}


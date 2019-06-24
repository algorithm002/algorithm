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
 * 思路：新建一个链表，头指针是一个哨兵位，遍历两个链表，比较大小，小的在前，并指针移到下一位
 */

function ListNode(val) {
    this.val = val;
    this.next = null;
}

var mergeTwoLists = function(l1, l2) {
    if (!l1 && !l2) {
        return null;
    }
    let head = new ListNode(null);
    let cur1 = l1;
    let cur2 = l2;
    let cur = head;
    while(cur1 || cur2) {
        if ((cur1 && !cur2) || (cur1 && cur2 && (cur2.val > cur1.val))) {
            cur.next = new ListNode(cur1.val);
            cur = cur.next;
            cur1 = cur1.next;
            continue;
        } else {
            cur.next = new ListNode(cur2.val);
            cur = cur.next;
            cur2 = cur2.next;
            continue;
        }
    }
    return head.next;
};
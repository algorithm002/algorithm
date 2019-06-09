/*
 * @lc app=leetcode.cn id=21 lang=csharp
 *
 * [21] 合并两个有序链表
 */
public class Solution {
    public ListNode MergeTwoLists (ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = MergeTwoLists (l1.next, l2);
            return l1;
        } else {
            l2.next = MergeTwoLists (l1, l2.next);
            return l2;
        }
    }
}
package week01;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/4  12:44
 * @描述  LeetCode : 21. 合并两个有序链表     https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        final MergeTwoSortedLists sortedLists = new MergeTwoSortedLists();
        final ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        final ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode listNode = sortedLists.mergeTwoLists(node1, node2);
        System.out.println(listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode node = new ListNode(Math.min(l1.val, l2.val));
        if (l1.val <= l2.val) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }
        ListNode curr = node; // why ?? why need create a temporary variable?
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return node;
    }

}

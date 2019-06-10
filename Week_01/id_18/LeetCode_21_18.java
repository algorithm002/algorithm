package Week_01.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/9 20:19
 */
public class LeetCode_21_18 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
        {
            return l1 == null ? l2 : l1;
        }
        ListNode temp = l1.val < l2.val ? l1 : l2;
        temp.next = mergeTwoLists(temp.next, temp == l1 ? l2 : l1);
        return temp;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

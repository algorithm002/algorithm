package week01;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/4  17:53
 * @描述 LeetCode: 24. 两两交换链表中的节点     https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs nodes = new SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode node = nodes.swapPairs2(head);
        System.out.println(node);
    }

    /**
     * 思路：
     * 循环解决
     *      1、加一个初始节点 root; root --> head
     *      2、三步完成转化过程：
     *          1、初始节点 next 指向 第二个节点 ； root.next = root.next.next
     *          2、原 之前的第一个节点的 next 指向 第二个节点的下一个 ：first.next = second
     *          3、第二个节点的 next 指向第一个 second.next = first;
     *          4、 交换完成后； 当前节点 往后面 走 两个  next;
     *              走一步 next: curr = second;
     *              走两步 next: curr = first (curr = second.next)
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode curr = root;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            curr.next = second;
            first.next = second.next;
            second.next = first;
            curr = first;
        }
        return root.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(head.next.next);
        next.next = head;
        return next;
    }
}

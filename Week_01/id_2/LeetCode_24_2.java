package com.llz.algorithm.algorithm2019.firstweek;

public class LeetCode_24_2 {

	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * You may not modify the values in the list's nodes, only nodes itself may be
	 * changed.
	 * 
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * @author liliangzi
	 * 
	 */

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * need to refact
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return head; 
		ListNode tempNext = null;
		if ((tempNext = head.next) != null) {
			ListNode tempNextNext = tempNext.next;
			ListNode newHead = tempNext;
			ListNode last = head;
			newHead.next = head;
			while (tempNextNext != null) {
				tempNext = tempNextNext;
				head = tempNext.next;
				if (head != null)
					tempNextNext = head.next;
				else {
					last.next = tempNext;
					tempNext.next = null;
					return newHead;
				}
				head.next = tempNext;
				last.next = head;
				last = tempNext;
			}
			last.next = null;
			return newHead;
		} else {
			return head;
		}
	}

	public static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
	}

	public static void test() {
		LeetCode_24_2 s = new LeetCode_24_2();
		LeetCode_24_2.ListNode head = s.new ListNode(1);
		// head.next = s.new ListNode(2);
		// head.next.next = s.new ListNode(3);
		// head.next.next.next = s.new ListNode(4);
		print(s.swapPairs(head));
	}

	public static void main(String[] args) {
		test();
	}

}

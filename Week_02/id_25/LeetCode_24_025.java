package com.mootal.algo.day8_24;

/**
 * Medium
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 1->2->3->4 | 2->1->4->3
 * <p>
 * 题解方案topics：
 * linked list
 *
 * @author li tong
 * @date 2019/6/10 9:41
 * @see Object
 * @since 1.0
 */
public class LeetCode_24_025 {

  private static class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return "{" + val +
              ", next=" + next +
              '}';
    }
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(4);
    a.next = b;
    b.next = c;
    c.next = d;
    System.out.println(swapPairs(a));
  }

  /**
   * 解法1 递归法<p>
   *
   * @param head
   * @return
   */
  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode after = head.next;
    ListNode nextTwo = after.next;
    ListNode back = swapPairs(nextTwo);
    head.next = back;
    after.next = head;
    return after;
  }

  /**
   * 解法2 遍历法<p>
   *
   * @param head
   * @return
   */
  public static ListNode swapPairs2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    ListNode temp = newHead;
    ListNode one = null;
    ListNode two = null;
    while (temp.next != null && temp.next.next != null) {
      one = temp.next;
      two = temp.next.next;
      one.next = two.next;
      two.next = one;
      temp.next = two;
      temp = one;
    }
    return newHead.next;
  }

}

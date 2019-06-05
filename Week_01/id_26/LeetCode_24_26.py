# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None: return
        if head.next is None: return head
        ret = ListNode(0)
        p = ret
        while head:
            if head.next:
                p.next = head.next
                head.next = head.next.next
                p.next.next = head
                p = p.next.next
                head = head.next
            else:
                head = head.next
        return ret.next
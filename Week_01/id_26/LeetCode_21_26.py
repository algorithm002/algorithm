# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        s = ListNode(0)
        k = s
        while l1 is not None or l2 is not None:
            if l1 is None:
                s.next = l2
                l2 = None
            elif l2 is None:
                s.next = l1
                l1 = None
            elif l1.val <= l2.val:
                s.next = ListNode(l1.val)
                l1 = l1.next
            else:
                s.next = ListNode(l2.val)
                l2 = l2.next
            s = s.next
        return k.next
        
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        cur1,cur2=l1,l2
        head,cur=None,None
        while cur1 or cur2:
            prev=cur
            if cur1 and cur2:
                if cur1.val>cur2.val:
                    cur=cur2
                    cur2=cur2.next
                else:
                    cur=cur1
                    cur1=cur1.next
            elif cur1:
                cur=cur1
                cur1=cur1.next
            else:
                cur=cur2
                cur2=cur2.next
            if not head:
                head=cur
            if prev:
                prev.next=cur
        return head
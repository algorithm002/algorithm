# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 时间复杂度  O(n)
# 空间复杂度  O(1)
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        last,node1,node2=None,head,head.next
        head=node2
        while node2:
            nextnode=node2.next
            node2.next=node1
            if last:
                last.next=node2
            node1.next=nextnode
            if not nextnode:
                break
            last=node1
            node1=nextnode
            node2=nextnode.next
        return head
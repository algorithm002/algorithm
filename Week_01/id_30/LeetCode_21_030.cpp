/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == nullptr)  return l2;
		if (l2 == nullptr)  return l1;
		ListNode* head = new ListNode(0);
		ListNode* p = head;
		while (l1 && l2)
		{
			ListNode* &n = (l1->val <= l2->val) ? l1 : l2;
			p->next = n;
			n = n->next;
			p = p->next;
		}
		ListNode* t = l1 ? l1 : l2;
		p->next = t;
        return head->next;
    }
};
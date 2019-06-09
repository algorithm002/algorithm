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
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr)  return nullptr;
		ListNode* newHead = new ListNode(0);
		newHead->next = head;
		ListNode* pre = newHead;
		ListNode* cur = head;
		while (cur)
		{
			ListNode* post = cur->next;
			if(post == nullptr)  break;
			cur->next = post->next;
			post->next = cur;
			pre->next = post;
			pre = cur;
			cur = cur->next;
		}
		return newHead->next;
    }
};
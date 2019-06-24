/*
 * @lc app=leetcode id=24 lang=cpp
 *
 * [24] Swap Nodes in Pairs
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

/*用递归的方法来解题
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
         if(head == nullptr || head->next == nullptr) {
            return head;
        }
        
        ListNode* pTempHead = head;
        ListNode* pTempNext = pTempHead->next;
        
        pTempHead->next = swapPairs(pTempNext->next);
        pTempNext->next = pTempHead;
        
        return pTempNext;
    }
};
*/
/*直接法--交换相邻的两个节点*/
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        
        ListNode tempNode(-1);
        tempNode.next = head;
        ListNode* p   = &tempNode;
        ListNode* p1  = nullptr;
        ListNode* p2  = nullptr;
        while(p->next && p->next->next){
            p1 = p->next;
            p2 = p1->next;
            
            p1->next = p2->next;
            p2->next = p1;
            p->next  = p2;
            
            p = p1;
        }
        return tempNode.next;
    }
};



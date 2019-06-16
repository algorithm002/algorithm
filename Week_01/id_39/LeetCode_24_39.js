/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 思路：画图！！！ 偶数项指向奇数项，第一个奇数项指向下一个偶数项，如若不存在则指向奇数项，都不存在指向null（重要！！！防止循环引用）；
 */
var swapPairs = function(head) {
    if (!head || !head.next) {
        return head;
    }
    let res = head.next;
    let odd = head;
    let even = odd.next;
    while(odd && even) {
        let nextOdd = even.next;
        even.next = odd;
        if (nextOdd) {
            odd.next = nextOdd.next ? nextOdd.next : nextOdd;
            odd = nextOdd;
            even = nextOdd.next;
        } else {
            odd.next = nextOdd
            break;
        }
    }
    return res;
 };
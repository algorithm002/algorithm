<?php


/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2)
    {
        if (null == $l1) return $l2;
        if (null == $l2) return $l1;

        $list = new ListNode(0);
        $cur = $list;
        while (null != $l1 && null != $l2) {
            if ($l1->val < $l2->val) {
                $cur->next = $l1;
                $cur = $cur->next;
                $l1 = $l1->next;
            } else {
                $cur->next = $l2;
                $cur = $cur->next;
                $l2 = $l2->next;
            }
        }

        if ($l1 == null) {
            $cur->next = $l2;
        }

        if ($l2 == null) {
            $cur->next = $l1;
        }

        return $list->next;
    }
}

class ListNode {
    public $val = 0;
    public $next = null;
    function __construct($val) { $this->val = $val; }
}
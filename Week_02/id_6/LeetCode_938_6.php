<?php

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @param Integer $L
     * @param Integer $R
     * @return Integer
     */
    function rangeSumBST($root, $L, $R)
    {
        if ($root == null) return $this->sum;
        if ($root->val > $R) {
            return $this->rangeSumBST($root->left, $L, $R);
        }
        if ($root->val < $L) {
            return $this->rangeSumBST($root->right, $L, $R);
        }
        return $root->val + $this->rangeSumBST($root->left, $L, $R) + $this->rangeSumBST($root->right, $L, $R);
    }

}
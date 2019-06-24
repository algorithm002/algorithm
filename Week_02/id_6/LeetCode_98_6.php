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

    public $flag = PHP_INT_MIN;

    /**
     * @param TreeNode $root
     * @return Boolean
     */
    function isValidBST($root) {
        if ($root == null) return true;
        if ($this->isValidBST($root->left)) {
            if ($this->flag > $root->val) return false;
            $this->flag = $root->val;
            return $this->isValidBST($root->right);
        }
    }
}
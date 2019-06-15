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
     * @return Boolean
     */
    function isSymmetric($root)
    {
        $this->isSymmetricRec($root, $root);
    }

    /**
     * @param TreeNode $left_root
     * @param TreeNode $right_root
     * @return Boolean
     */
    function isSymmetricRec($left_root, $right_root)
    {
        if ($left_root == null && $right_root == null) return true;
        if ($left_root == null || $right_root == null) return false;
        if ($left_root->val == $right_root->val) {
            return $this->isSymmetricRec($left_root->left, $right_root->right) && $this->isSymmetricRec($left_root->right, $right_root->left);
        }
        return false;
    }
}
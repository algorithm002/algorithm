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

    public $levels = [];

    /**
     * @param TreeNode $root
     * @return Integer[][]
     */
    function levelOrder($root)
    {
        if ($root == null) return [];
        // BFS
        $this->bfs($root, 0);
        return $this->levels;

    }

    function bfs($root, $level)
    {
        $this->levels[$level][] = $root->val;

        if ($root->left != null) {
            $this->bfs($root->left, $level + 1);
        }

        if ($root->right != null) {
            $this->bfs($root->right, $level + 1);
        }
    }
}
/*
 * @lc app=leetcode id=337 lang=cpp
 *
 * [337] House Robber III
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * T(n) = O(N)
 */
class Solution {
public:
    int rob(TreeNode* root) {
        int lm = 0, rm = 0;
        return robber(root, lm, rm);
    }

    int robber(TreeNode* root, int& lm, int& rm) {
        if (root == nullptr)
            return 0;
        int lm1 = 0, lm2 = 0, rm1 = 0, rm2 = 0;
        lm = robber(root->left, lm1, lm2);
        rm = robber(root->right,rm1, rm2);
        return max(root->val + lm1 + lm2 + rm1 + rm2, lm + rm);
    }
};

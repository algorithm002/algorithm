/*
 * @lc app=leetcode id=783 lang=cpp
 *
 * [783] Minimum Distance Between BST Nodes
 * T(n) = O(N)
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    int res = INT_MAX;
    int preVal = -1;
    int minDiffInBST(TreeNode *root)
    {
        if (root->left != NULL)
            minDiffInBST(root->left);
        if (preVal >= 0)
            res = min(res, root->val - preVal);
        preVal = root->val;
        if (root->right != NULL)
            minDiffInBST(root->right);
        return res;
    }
};

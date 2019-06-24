/*
 * @lc app=leetcode id=107 lang=cpp
 *
 * [107] Binary Tree Level Order Traversal II
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * Without reverse, use in order traversal.
 * T(n) = O(N)
 * S(n) = O(N)
 */
class Solution
{
public:
    vector<vector<int>> levelOrderBottom(TreeNode *root)
    {
        int h = getTreeheight(root);
        vector<vector<int>> res(h);
        inOrderTraversal(root, h - 1, res);
        return res;
    }

    int getTreeheight(TreeNode *root)
    {
        return root ? (max(getTreeheight(root->left), getTreeheight(root->right)) + 1) : 0;
    }

    void inOrderTraversal(TreeNode *root, int level, vector<vector<int>> &res)
    {
        if (root == nullptr)
            return;
        inOrderTraversal(root->left, level - 1, res);
        res[level].push_back(root->val);
        inOrderTraversal(root->right, level - 1, res);
    }
};

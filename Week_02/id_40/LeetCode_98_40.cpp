/*
 * @lc app=leetcode id=98 lang=cpp
 *
 * [98] Validate Binary Search Tree
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
class Solution {
public:
    int* last = NULL;
    bool isValidBST(TreeNode* root) {
        if (root){
            if(!isValidBST(root->left)) 
                return false;
            if (last && *last>=root->val) 
                return false;
            last = &root->val;
            if(!isValidBST(root->right)) 
                return false;
            return true;
        }
        else 
            return true;
    };
};


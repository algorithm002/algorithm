/*
 * @lc app=leetcode id=257 lang=cpp
 *
 * [257] Binary Tree Paths
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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> answer;
        if (root != nullptr) {
            searchBT(root, "", answer);
        }
        return answer;
    }

private:
    void searchBT(TreeNode* root, string path, vector<string>& answer) {
        if (root->left == nullptr && root->right == nullptr) {
            answer.push_back(path + to_string(root->val));            
        }
        if (root->left != nullptr) {
            searchBT(root->left, path + to_string(root->val) + "->", answer);
        }
        if (root->right != nullptr) {
            searchBT(root->right, path + to_string(root->val) + "->", answer);
        }
    }
};


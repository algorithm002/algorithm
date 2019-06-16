/*
 * @lc app=leetcode id=103 lang=cpp
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;

        if (root == NULL) {
            return {};
        }
        queue<TreeNode*> q;
        int i = 0;

        q.push(root);

        while (!q.empty()) {
            vector<int> v;
            int s = q.size();
            while (s--) {
                root = q.front();
                q.pop();
                v.push_back(root->val);
                if (root->left) {
                    q.push(root->left);
                }
                if (root->right) {
                    q.push(root->right);
                }
            }
            if (i++ & 1) {
                reverse(v.begin(), v.end());
            }
            res.push_back(v);
        }
        return res;
    }
};


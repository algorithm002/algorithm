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
        vector<vector<int>> result;
        queue<TreeNode*> q;
        bool zig = true; /*left then right on true*/
        q.push(root);
        stack<int> s;
        while(!q.empty() && root)
        {   
            vector<int> vec;
            int cnt = q.size();
            while(cnt > 0)
            {
                TreeNode* node = q.front();
                q.pop();
                if(node)
                {
                    if(zig) vec.push_back(node->val);
                    else s.push(node->val);
                    if(node->left) q.push(node->left);
                    if(node->right) q.push(node->right);
                }
                
                cnt--;
            }
            zig = !zig;
            while(!s.empty())
            {
                vec.push_back(s.top());
                s.pop();
            }
            result.push_back(vec);
        }
        return result;
        
    }
};


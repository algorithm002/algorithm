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
 * T(n) = O(N)
 * S(n) = O(N)
 */
class Solution
{
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode *root)
    {
        vector<vector<int>> res;
        if (root == nullptr)
            return res;
        deque<TreeNode *> dq;
        bool leftToRight = false;

        dq.push_back(root);

        while (!dq.empty())
        {
            int n = dq.size();
            vector<int> level;
            TreeNode *current;
            leftToRight = !leftToRight;
            
            for (int i = 0; i < n; i++)
            {
                if (leftToRight)
                {
                    current = dq.back();
                    dq.pop_back();
                    level.push_back(current->val);

                    if (current->left)
                    {
                        dq.push_front(current->left);
                    }
                    if (current->right)
                    {
                        dq.push_front(current->right);
                    }
                }
                else
                {
                    current = dq.front();
                    dq.pop_front();
                    level.push_back(current->val);
                    if (current->right)
                    {
                        dq.push_back(current->right);
                    }
                    if (current->left)
                    {
                        dq.push_back(current->left);
                    }
                }
            }
            if (!level.empty())
                res.push_back(std::move(level));
        }
        return res;
    }
};

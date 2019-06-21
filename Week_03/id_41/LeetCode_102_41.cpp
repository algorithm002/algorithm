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
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        queue<TreeNode*> q;
        if (root == nullptr)
            return res;
        q.push(root);
        while (!q.empty())
        {
            vector<int> level;
            int n = q.size();
            for (int i = 0; i < n; i++)
            {
                auto current = q.front();
                q.pop();
                if (current->left)
                    q.push(current->left);
                if (current->right)
                    q.push(current->right);
                level.push_back(current->val);
            }
            res.push_back(level);
        }
        return res;
    }
};

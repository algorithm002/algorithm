/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * BFS: T(n) = O(K) K为树的最小深度
 * DFS: T(n) = O(N) N为树结点数
 */
 
DFS(C):
static inline int min(int a, int b)
{
    return a < b ? a : b;
}

int minDepth(struct TreeNode* root){
    if (root == NULL)
        return 0;
    int left = minDepth(root->left);
    int right = minDepth(root->right);
    
    return (left == 0 || right == 0) ? (left + right + 1) : min(left, right) + 1; 
}



BFS:
class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == NULL)
            return 0;
        queue<TreeNode*> q;
        int depth = 0;
        q.push(root);
        while (!q.empty())
        {
            int n = q.size();
            depth++;

            for (int i = 0; i < n; i++)
            {
                TreeNode* r = q.front();
                q.pop();
                // 注意左右子树同时为空的情况
                if (r->left == NULL && r->right == NULL)
                    return depth;
                if (r->left != NULL)
                    q.push(r->left);
                if (r->right != NULL)
                    q.push(r->right);
            }
        }
        return depth;
    }
};


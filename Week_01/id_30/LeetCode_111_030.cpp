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
    int minDepth(TreeNode* root) {
        if(root == nullptr)  return 0;
        int leftDepth = -1;
        if(root->left)
        {
            leftDepth = minDepth(root->left);
        }
        int rightDepth = -1;
        if(root->right)
        {
            rightDepth = minDepth(root->right);
        }
        if(leftDepth == -1 && rightDepth == -1)
        {
            return 1;
        }
        if(leftDepth != -1 && rightDepth != -1)
        {
            return leftDepth < rightDepth ? leftDepth : rightDepth;
        }
        if(leftDepth != -1)
        {
            return leftDepth;
        }
        else
        {
            return rightDepth;
        }
    }
};
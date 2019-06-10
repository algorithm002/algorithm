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
    bool isSymmetric(TreeNode* root) {
        if (root == nullptr)  return true;
        return CheckSymmetric(root->left, root->right);
    }

    bool CheckSymmetric(TreeNode* leftNode, TreeNode* rightNode)
    {
        if (leftNode && rightNode)                             return leftNode->val == rightNode->val && CheckSymmetric(leftNode->left, rightNode->right) && CheckSymmetric(leftNode->right, rightNode->left);
        else if (leftNode == nullptr && rightNode == nullptr)  return true;
        else                                                   return false;
    }
};
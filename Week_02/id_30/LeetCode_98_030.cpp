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
    bool isValidBST(TreeNode* root) {
		return isValidBST(root, nullptr, nullptr);
	}

	bool isValidBST(TreeNode* root, TreeNode* minValueNode, TreeNode* maxValueNode)
	{
		if (root == nullptr)  return true;
		if (minValueNode && root->val <= minValueNode->val)  return false;
		if (maxValueNode && root->val >= maxValueNode->val)  return false;
		return isValidBST(root->left, minValueNode, root) && isValidBST(root->right, root, maxValueNode);
	}
};
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
    bool hasPreValue = false;
	int preValue = 0;
	int minDis = INT_MAX;
	int minDiffInBST(TreeNode* root) {
		if (root == nullptr)  return 0;
		minDiffInBST(root->left);
		if (hasPreValue)
		{
			minDis = min(minDis, root->val - preValue);
		}
		else
		{
			hasPreValue = true;
		}
		preValue = root->val;
		minDiffInBST(root->right);
		return minDis;
	}
};
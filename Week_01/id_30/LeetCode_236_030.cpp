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
    vector<TreeNode*> pValues, qValues;
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
		vector<TreeNode*> path;
		dfs(root, p, q, path);
		int minSize = min(pValues.size(), qValues.size());
		for (int i = 0; i < minSize; ++i)
		{
			if (pValues[i] != qValues[i])
			{
				return pValues[i - 1];
			}
		}
		return pValues[minSize - 1];
	}

	void dfs(TreeNode* root, TreeNode* p, TreeNode* q, vector<TreeNode*>& path)
	{
		if (root == nullptr)  return;
		path.push_back(root);
		if (root == p)  pValues = path;
		else if (root == q)  qValues = path;
		dfs(root->left, p, q, path);
		dfs(root->right, p, q, path);
		path.pop_back();
	}
};
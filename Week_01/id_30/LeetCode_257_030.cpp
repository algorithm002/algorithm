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
    vector<string> results;
	vector<string> binaryTreePaths(TreeNode* root) {
		dfs(root, "");
		return results;
	}

	void dfs(TreeNode* root, string result)
	{
		if (root == nullptr)  return;
		result += to_string(root->val);
		if (root->left == nullptr && root->right == nullptr)
		{
			results.push_back(result);
			return;
		}
		else
		{
			result += "->";
		}
		dfs(root->left, result);
		dfs(root->right, result);
	}
};
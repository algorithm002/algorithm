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
        vector<vector<int>> results;
		if (root == nullptr)  return results;
		stack<TreeNode*> s[2];
		int currentStack = 0;
		int anotherStack = 1 - currentStack;
		s[currentStack].push(root);
		bool reverse = false;
		do
		{
			vector<int> oneLevelResult;
			do
			{
				TreeNode* node = s[currentStack].top();
				s[currentStack].pop();
				oneLevelResult.push_back(node->val);
				if (reverse)
				{
					if (node->right)  s[anotherStack].push(node->right);
					if (node->left)  s[anotherStack].push(node->left);
				}
				else
				{
					if (node->left)  s[anotherStack].push(node->left);
					if (node->right)  s[anotherStack].push(node->right);
				}
			}while (!s[currentStack].empty());
			results.push_back(oneLevelResult);
			swap(currentStack, anotherStack);
			reverse = !reverse;
		} while (!s[currentStack].empty());
		return results;
    }
};
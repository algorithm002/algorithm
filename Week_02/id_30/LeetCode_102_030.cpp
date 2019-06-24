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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> results;
		if (root == nullptr)  return results;
		queue<TreeNode*> nodeQueue;
		nodeQueue.push(root);
		while (!nodeQueue.empty())
		{
			vector<int> oneLevelResult;
			int nodesCountInLevel = nodeQueue.size();
			while(nodesCountInLevel > 0)
			{
				TreeNode* node = nodeQueue.front();
				nodeQueue.pop();
				oneLevelResult.push_back(node->val);
				if (node->left)  nodeQueue.push(node->left);
				if (node->right)  nodeQueue.push(node->right);
				--nodesCountInLevel;
			}
			results.push_back(oneLevelResult);
		}
		return results;
    }
};
/*
 * @lc app=leetcode id=429 lang=cpp
 *
 * [429] N-ary Tree Level Order Traversal
 */
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
T(n) = O(N);
S(n) = O(N);
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        queue<Node*> q;
        if (root == nullptr)
            return res;
        q.push(root);
        while (!q.empty())
        {
            vector<int> level;
            int n = q.size();
            for (int i = 0; i < n; i++)
            {
                Node* current = q.front();
                q.pop();
                level.push_back(current->val);
                // diff with Binary Tree part.
                if (current->children.size() > 0)
                    for (auto child : current->children)
                        q.push(child);
            }
            res.push_back(level);
        }
        return res;
    }
};

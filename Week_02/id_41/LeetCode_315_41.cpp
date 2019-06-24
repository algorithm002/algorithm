/*
 * @lc app=leetcode id=315 lang=cpp
 *
 * [315] count of Smaller Numbers After Self
 * T(n) = O(N)
 * S(n) = O(N)
 */
class Solution
{
public:
    vector<int> countSmaller(vector<int> &nums)
    {
        TreeNode *root = NULL;
        vector<int> res(nums.size());
        for (int i = nums.size() - 1; i >= 0; i--)
            res[i] = bstInsert(root, nums[i]);
        return res;
    }

private:
    struct TreeNode
    {
        int val;
        int sum;
        TreeNode *left;
        TreeNode *right;
        TreeNode(int v, int s) : val(v), sum(s), left(NULL), right(NULL) {}
    };

    int bstInsert(TreeNode* &root,
                  int val)
    {
        int count = 0;
        if (root == NULL)
        {
            root = new TreeNode(val, 0);
            return 0;
        }

        if (val < root->val)
        {
            root->sum++;
            count = bstInsert(root->left, val);
        }
        else
        {
            count = bstInsert(root->right, val) +
                    root->sum +
                    (root->val < val ? 1 : 0);
        }

        return count;
    }
};


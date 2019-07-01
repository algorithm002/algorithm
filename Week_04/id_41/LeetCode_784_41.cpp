/*
 * @lc app=leetcode id=784 lang=cpp
 *
 * [784] Letter Case Permutation
 * T(n) = O(N)
 * S(n) = O(N)
 */
class Solution {
public:
    vector<string> letterCasePermutation(string S) {
        if (S.size() == 0)
            return res;
        helper(S, 0);
        return res;
    }
private:
    vector<string> res;
    void helper(string s, int i)
    {
        // terminator
        if (i == s.size())
        {
            res.push_back(s);
            return;
        }
        // drill down
        helper(s, i + 1);

        if (isalpha(s[i]))
        {
            // process current : letter case change
            s[i] ^= 1 << 5;
            helper(s, i + 1);
            // restore
            s[i] ^= 1 << 5;
        }
    }
};

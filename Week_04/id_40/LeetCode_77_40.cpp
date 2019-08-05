/*
 * @lc app=leetcode id=77 lang=cpp
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (48.20%)
 * Likes:    804
 * Dislikes: 47
 * Total Accepted:    208.5K
 * Total Submissions: 432.6K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> result;
		int i = 0;
		vector<int> p(k, 0);
		while (i >= 0) {
			p[i]++;
			if (p[i] > n) 
                --i;
			else if (i == k - 1)
                 result.push_back(p);
			else {
			    ++i;
			    p[i] = p[i - 1];
			}
		}
		return result;

    }
};


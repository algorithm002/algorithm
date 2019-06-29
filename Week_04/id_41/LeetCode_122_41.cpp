/*
 * @lc app=leetcode id=122 lang=cpp
 *
 * [122] Best Time to Buy and Sell Stock II
 * T(n) = O(N)
 * S(n) = O(1)
 */
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int res = 0;

        for (int i = 1; i < n; i++)
        {
            if (prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        }
        return res;
    }
};

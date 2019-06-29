/*
 * @lc app=leetcode id=121 lang=cpp
 *
 * [121] Best Time to Buy and Sell Stock
 * T(n) = O(N)
 * T(n) = O(1)
 */
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxPro = 0;
        int minPrice = INT_MAX;

        for (auto p : prices)
        {
            minPrice = min(minPrice, p);
            maxPro = max(p - minPrice, maxPro);
        }
        return maxPro;
    }
};

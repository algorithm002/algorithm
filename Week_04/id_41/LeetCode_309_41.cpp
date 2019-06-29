/*
 * @lc app=leetcode id=309 lang=cpp
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 * T(n) = O(N)
 * S(n) = O(1)
 */
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int prev_buy = 0;
        int prev_sell = 0;
        int buy = INT_MIN;
        int sell = 0;

        for (auto price : prices)
        {
            prev_buy = buy;
            buy = max(prev_sell - price, buy);
            prev_sell = sell;
            sell = max(prev_buy + price, sell);
        }
        return sell;
    }
};

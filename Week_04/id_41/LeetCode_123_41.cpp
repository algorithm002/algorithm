/*
 * @lc app=leetcode id=123 lang=cpp
 *
 * [123] Best Time to Buy and Sell Stock III
 * dp[day][kthTransaction][state]
 * day can be optimized in prices iteration.
 * kthTransaction: 0(base) 1(1st transction) or 2(2nd transaction)
 * state: sell(0) or buy(1)
 * 
 * dp[kthTransaction][state]
 * dp[k][0] = max(dp[k][0], dp[k][1] + price);
 * dp[k][1] = max(dp[k][1], dp[k-1][0] - price);
 * Time complexity : O(day * transactionCount)
 * Space complexity : O(1)
 */
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        vector<vector<int>> dp(3, vector<int>(2, 0));

        for (int k = 1; k <= 2; k++)
        {
            dp[k][0] = 0;
            dp[k][1] = INT_MIN;
        }

        for (int price : prices)
        {
            for (int k = 1; k <= 2; k++)
            {
                dp[k][0] = max(dp[k][0], dp[k][1]     + price);
                dp[k][1] = max(dp[k][1], dp[k - 1][0] - price);
            }
        }
        return dp[2][0];
    }
};

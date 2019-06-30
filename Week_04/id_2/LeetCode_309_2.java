//Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
//
//
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
// After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
//
//
// Example:
//
//
//Input: [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
//

package com.llz.algorithm.algorithm2019.fourthweek;

public class LeetCode_309_2 {

    /**
     * Referenced from discussion.
     * buy[i] means before day i what is the maxProfit for any sequence end with buy.
     * sell[i] means before day i what is the maxProfit for any sequence end with sell.
     * Where price is the price of day i.
     * buy[i]=Max(buy[i-1],sell[i-2]-price)
     * sell[i]=Max(sell[i-1],buy[i-1]+price)
     * Reduce space complexity O(n) to O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) return 0;
        int preBuy = -prices[0], buy = -prices[0], sell = 0, preSell = 0, prePreSell = 0;
        for (int i = 1; i < length; i++) {
            buy = Math.max(prePreSell - prices[i], preBuy);
            sell = Math.max(preSell, preBuy + prices[i]);
            prePreSell = preSell;
            preSell = sell;
            preBuy = buy;
        }
        return sell;
    }

    /**
     * Referenced from discussion.
     * buy[i] means before day i what is the maxProfit for any sequence end with buy.
     * sell[i] means before day i what is the maxProfit for any sequence end with sell.
     * Where price is the price of day i.
     * buy[i]=Max(buy[i-1],sell[i-2]-price)
     * sell[i]=Max(sell[i-1],buy[i-1]+price)
     *
     * @param prices
     * @return
     */
    public int maxProfitOptimised(int[] prices) {
        int length = prices.length;
        if (length < 2) return 0;
        int[] buy = new int[length];
        int[] sell = new int[length];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], -prices[1]);
        for (int i = 1; i < length; i++) {
            if (i > 1)
                buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return Math.max(buy[length - 1], sell[length - 1]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        LeetCode_309_2 l = new LeetCode_309_2();
        System.out.println(l.maxProfit(prices));
    }
}

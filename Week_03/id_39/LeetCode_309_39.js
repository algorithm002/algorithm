/**
 * @param {number[]} prices
 * @return {number}
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 只考虑前一天
 */
var maxProfit = function(prices) {
    let sell = [0], buy = [-prices[0]], cool = [0];
    for (let i = 1; i < prices.length; i++) {
        sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1]);
        buy[i] = Math.max(cool[i-1] - prices[i], buy[i-1]);
        cool[i] = Math.max(sell[i-1], buy[i-1], cool[i-1]);
    }
    return sell[sell.length-1];
};
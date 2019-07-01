/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length <= 1) return 0;
		int profit = 0, min = prices[0];
		for(int i = 0;i < prices.length;i++){
			if(prices[i] < min){
				min = prices[i];
			}else if(prices[i] > min + fee){
				profit += prices[i] - min - fee;
				min = prices[i] - fee;
			}
		}
		return profit;
    }
}


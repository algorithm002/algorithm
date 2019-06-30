class Solution
{
public:
    int maxProfit(int k, vector<int> &prices)
    {
        if (k <= 0 || prices.size() <= 1)
            return 0;

        if (k > prices.size() / 2)
            return maxProfixWithoutTransactionLimit(prices);

        vector<int> buy(k, INT_MIN);
        vector<int> sell(k, 0);

        for (auto price : prices)
        {
            buy[0] = max(buy[0], -price);
            sell[0] = max(sell[0], buy[0] + price);
            for (int j = 1; j < k; j++)
            {
                buy[j] = max(buy[j], sell[j - 1] - price);
                sell[j] = max(sell[j], buy[j] + price);
            }
        }

        return max(sell[k - 1], 0);
    }

private:
    int maxProfixWithoutTransactionLimit(vector<int> &prices)
    {
        int result = 0;
        for (int i = 1; i < prices.size(); i++)
        {
            result += max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
};

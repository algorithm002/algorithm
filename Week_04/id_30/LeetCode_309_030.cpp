class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
		int mpi_0 = 0, mpi_1 = INT_MIN, mp_pre_i_0 = 0;
		for (int i = 0; i < n; ++i)
		{
			int cur_i_0 = mpi_0;
			mpi_0 = max(mpi_0, mpi_1 + prices[i]);
			mpi_1 = max(mpi_1, mp_pre_i_0 - prices[i]);
			mp_pre_i_0 = cur_i_0;
		}
		return mpi_0;
    }
};
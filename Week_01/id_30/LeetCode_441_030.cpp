class Solution {
public:
    int arrangeCoins(int n) {
        int begin = 1, end = sqrt(2LL * n);
        while (begin <= end)
        {
            int mid = begin + (end - begin) / 2;
            long long sum = mid * (1LL + mid) / 2;
            if (sum < n)
            {
                begin = mid + 1;
            }
            else if (sum > n)
            {
                end = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        return end;
    }
};
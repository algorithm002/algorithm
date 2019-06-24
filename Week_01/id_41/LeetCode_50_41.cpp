/*
 * @lc app=leetcode id=50 lang=cpp
 *
 * [50] Pow(x, n)
 */
class Solution
{
public:
    double myPow(double x, int n)
    {
        if (n == 0)
            return 1;
        if (n < 0)
        {
            n = -n;
            x = 1 / x;
        }
        return (n & 1) ? pow(x * x, n / 2) * x : pow(x * x, n / 2);
    }
};

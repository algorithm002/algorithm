/*
 * @lc app=leetcode id=70 lang=cpp
 *
 * [70] Climbing Stairs
 */

// dp T(n) = O(n) S(n) = O(n)
class Solution_raw_dp
{
public:
    int climbStairs(int n)
    {
        vector<int> dp(n);
        if (n == 1)
            return 1;
        if (n < 1)
            return 0;

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
};

// dp space optimization T(n) = O(n) S(n) = O(1)
class Solution_dp_space_opt
{
public:
    int climbStairs(int n)
    {
        vector<int> dp(n);
        if (n == 1)
            return 1;
        if (n < 1)
            return 0;

        // dp[0] = 1;
        int first = 1;
        // dp[1] = 2;
        int second = 2;
        int third = 0;

        for (int i = 2; i < n; i++)
        {
            // dp[i] = dp[i - 1] + dp[i - 2];
            third = second + first;
            first = second;
            second = third;
        }
        return second;
    }
};

// recursion T(n) = O(2^n) S(n) = O(n)
class Solution_recursion
{
public:
    int climbStairs(int n)
    {
        if (n <= 2)
            return n;
        vector<int> memo(n, -1);
        return climbStairsHelper(0, n, memo);
    }

private:
    int climbStairsHelper(int i, int n, vector<int> &memo)
    {
        if (i > n)
            return 0;
        if (i == n)
            return 1;

        if (memo[i] != -1)
        {
            return memo[i];
        }

        memo[i] = climbStairsHelper(i + 1, n, memo) +
                  climbStairsHelper(i + 2, n, memo);
        return memo[i];
    }
};

// recursion: matrix multiply T(n) = O(logn) S(n) = O(n)
class Solution
{
public:
    int climbStairs(int n)
    {
        vector<vector<int>> res(4);
        res = powermatrix(n);
        return res[0][0];
    }

    vector<vector<int>> powermatrix(int n)
    {
        vector<vector<int>> Q = {{1, 1}, {1, 0}};
        vector<vector<int>> ret(4);

        if (n == 1)
            return Q;
        ret = powermatrix(n / 2);
        ret = cross(ret, ret);

        if (n & 1)
            ret = cross(ret, Q);

        return ret;
    }

    vector<vector<int>> cross(vector<vector<int>> A, vector<vector<int>> B)
    {
        vector<vector<int>> C(2, vector<int>(2, 0));
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                C[i][j] = A[i][0] * B[0][j] + A[i][1] * B[1][j];
            }
        }

        return C;
    }
};

// recursion: space optimized matrix multiply T(n) = O(logn) S(n) = O(n)
class Solution_opt_matrix_multiply
{
public:
    int climbStairs(int n)
    {
        return (n <= 2) ? n : helper(n).second;
    }

private:
    pair<int, int> helper(int n)
    {
        if (n == 0)
        {
            return {0, 1};
        }

        pair<int, int> x = helper(n / 2);
        pair<int, int> y = {x.first * (2 * x.second - x.first),
                            x.first * x.first + x.second * x.second};

        return n & 1 ? make_pair(y.second, y.first + y.second) : y;
    }
};

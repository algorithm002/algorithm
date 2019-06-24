/*
 * @lc app=leetcode id=263 lang=cpp
 *
 * [263] Ugly Number
 */
class Solution
{
public:
    bool isUgly(int num)
    {
        for (int i = 2; i < 6 && (num != 0); i++)
        {
            while (num % i == 0)
            {
                num /= i;
            }
        }
        return num == 1;
    }
};

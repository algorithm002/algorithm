package com.github.lifelab.leetcode.problemset;

/**
 * Pow(x, n) @https://leetcode-cn.com/problems/powx-n/
 *
 * @author Weichao Li (liweichao0102@gmail.com)
 * @since 2019-06-06
 */
public class Solution50 {

    public double myPow(double x, int n) {

        if (n < 0) {
            return 1 / halfPow(x, -n);
        } else {
            return halfPow(x, n);
        }

    }

    public double halfPow(double x, int n) {

        //terminator
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        //process && drill down

        double result;

        boolean flag = n % 2 == 0;

        double temp = halfPow(x, n / 2);

        // 优化三目，直接return
        if (flag) {
            result = temp * temp;
        } else {
            result = temp * temp * x;
        }

        return result;
    }
}
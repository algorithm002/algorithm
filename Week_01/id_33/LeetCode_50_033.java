/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */
class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        double half = myPow(x, n/2);
        if(n % 2 == 0)
            return half * half;
        else
            return n > 0 ? half * half * x : half * half * (1/x); 
    }
}


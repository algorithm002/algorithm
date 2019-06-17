/*
 * @lc app=leetcode id=50 lang=cpp
 *
 * [50] Pow(x, n)
 */
/*这道题最容易错的地方在于超时，所以采用折半计算*/
class Solution {
public:
    double myPow(double x, int n) {
        long N = n;
        if(N > 0)
            return pow(x, N);
        else
            return 1/pow(x,-N);
    }
public:
    double pow(double x, long n){
        if(n == 0)
            return 1.0;
        if(n%2 == 1){
            double y = pow(x, (n-1)/2);
            return y*y*x;
        }
        else{
            double y = pow(x, n/2);
            return y*y;
        }
    }
};


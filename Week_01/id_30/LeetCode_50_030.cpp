class Solution {
public:
    double myPow(double x, int n) {
        if (n == 0)  return 1.0;
		if (n == 1)  return x;
		if (n == -1)  return 1 / x;
		double t = myPow(x, n / 2);
		t *= t;
		if (n & 1)
		{
			if (n > 0) t *= x;
			else      t *= 1 / x;
		}
		return t;
    }
};
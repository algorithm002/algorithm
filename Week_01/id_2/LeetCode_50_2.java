package com.llz.algorithm.algorithm2019.firstweek;

public class LeetCode_50_2 {

	public double myPow(double x, int n) {
		if (n < 0) {
			if (n == Integer.MIN_VALUE)
				return 1 / (myPow(x, Integer.MAX_VALUE) * x);
			return 1 / myPow(x, -n);
		}
		if (n == 0)
			return 1;
		if (n == 1)
			return x;

		double temp = myPow(x, n / 2);
		return n % 2 == 0 ? temp * temp : x * temp * temp;
	}

	public static void main(String[] args) {
		LeetCode_50_2 p = new LeetCode_50_2();
		System.out.println(p.myPow(2.1, 3));
	}

}

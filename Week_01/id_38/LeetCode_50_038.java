/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */
class LeetCode_50_038 {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        double half = myPow(x, n / 2);


        // 建议这里直接return三目运算符
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

    }

    public static void main(String[] args) {
        LeetCode_50_038 testCode_50_038 = new LeetCode_50_038();
        System.out.println(testCode_50_038.myPow(2, 10));
    }
}


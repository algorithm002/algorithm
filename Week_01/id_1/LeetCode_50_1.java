package week01;

/**
 * LeetCode : 50. Pow(x, n)    https://leetcode-cn.com/problems/powx-n/
 */
public class PowXN {
    public static void main(String[] args) {
        int i=1;
        System.out.println(i/2);
        System.out.println(new PowXN().myPow(2, 10));
        System.out.println(new PowXN().myPow(2.1, 3));
        System.out.println(new PowXN().myPow(2.0, -2));
        System.out.println("-------------");
        System.out.println(new PowXN().myPow3(2, 5));
        System.out.println(new PowXN().myPow3(2, 10));
        System.out.println(new PowXN().myPow3(2.1, 3));
        System.out.println(new PowXN().myPow3(2.0, -2));
    }

    /**
     * Method 1 : 暴力破解法
     * 时间复杂度： O(N)  ;   空间复杂度：  O(1)
     */
    public double myPow(double x, int n) {
        long newN = n;
        if (newN < 0) {
            x = 1 / x;
            newN = -newN;
        }
        double sum = 1;
        for (int i = 0; i < newN; i++) {
            sum *= x;
        }
        return sum;
    }

    /**
     * Method 2 :   递归 二分法
     *  时间复杂度:  O(logN) ;   空间复杂度：  O(logN)
     */
    public double myPow2(double x, int n) {
        long newN = n;
        if (newN < 0) {
            x = 1 / x;
            newN = -newN;
        }
        return fastPow(x, newN);

    }

    private double fastPow(double x, long newN) {
        // 终止条件
        if (newN == 0) {
            return 1.0;
        }
        // 要做的事情
        double fastPow = fastPow(x, newN / 2);
        if (newN % 2 == 0) {
            return fastPow * fastPow;
        }
        return fastPow * fastPow * x;
        // 下一层
    }

    /**
     *  Method 3 :  偶数时 进行 幂乘；奇数 之前的结果集 * 当前自己；
     *  时间复杂度： O(logN)  ;   空间复杂度：  O(1)    ;
     */
    public double myPow3(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result=1;
        double cur=x;
        for(long i=N;i>0;i/=2){
            if(i%2==1){
                result*=cur;
            }
            cur*=cur;
        }
        return result;
    }


}

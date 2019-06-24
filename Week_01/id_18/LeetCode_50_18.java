package Week_01.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/10 13:33
 */
public class LeetCode_50_18 {
    private double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n == Integer.MIN_VALUE){
            return 1.0 / myPow(x, -(n/2));
        }

        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }


        double y = myPow(x, n / 2);
        y *= y;

        return n % 2 == 1 ? y * x : y;
    }
}

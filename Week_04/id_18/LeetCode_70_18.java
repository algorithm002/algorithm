package Week_04.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/27 17:48
 */
public class LeetCode_70_18 {
    public int climbStairs(int n) {
        return climbStairs(n, new int[n + 1]);
    }

    private int climbStairs(int n, int[] nums) {
        if (n <= 2) {
            return n;
        }

        if (nums[n] > 0) {
            return nums[n];
        }

        int num = climbStairs(n - 1, nums) + climbStairs(n - 2, nums);
        nums[n] = num;

        return num;
    }

    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    public int climbStairs3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }
}

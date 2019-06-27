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
}

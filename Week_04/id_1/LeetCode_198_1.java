package week04;

/**
 * Auth:luoxiang
 * Time:2019/6/30 5:46 PM
 * Desc:    DP 打家劫舍
 */
public class LeetCode_198_1 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_198_1().rob(new int[]{1,2,3,1}));
        System.out.println(new LeetCode_198_1().rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) return len == 0 ? 0 : nums[0];
        int[] dp = new int[len];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }
}

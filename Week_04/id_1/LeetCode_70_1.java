package week01;

/**
 * Auth:luoxiang
 * Time:2019/6/30 5:17 PM
 * Desc:    爬楼梯
 */
public class LeetCode_70_1 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_70_1().climbStairs(3));
    }

    public int climbStairs(int n) {
        if(n<3) return n;
        int[] dp = new int[n + 1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}

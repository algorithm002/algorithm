package com.leecode.week04;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 */
public class Leetcode_198_35 {

    public static void main(String[] args) {
        Leetcode_198_35 lc=new Leetcode_198_35();

        System.out.println(lc.rob(new int[]{1,2,3,1}));

        System.out.println(lc.rob(new int[]{2,9,7,3,1}));


    }

    /**
     * 相邻的房间不能偷，转换成我在当前的一套房间的行为
     * 1.前一个房间我没有偷，那么当前的房间我可以偷
     * 2.前一个房间我是偷了的，当前的房间就不能偷了
     * 所以偷到当前的房间的最高金额就是在两种方案中选择最高的
     *
     * dp[i]=max(dp[i-1]+0),dp[i-2]+num[i]
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];

         if(nums==null||nums.length==0){
             return 0;
         }

         if(nums.length==1){
             return nums[0];
         }

        if(nums.length==2){
           return Math.max(nums[0],nums[1]);
        }


        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);//第一次偷了就是dp[0],第一次不偷0+第二次偷num[1]，两种情况找个比较大的

        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];
    }
}

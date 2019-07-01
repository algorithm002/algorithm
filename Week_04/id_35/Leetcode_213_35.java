package com.leecode.week04;

/**
 * 213. 打家劫舍 II 这次去偷四合院，屋子是连着的 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
 */
public class Leetcode_213_35 {



    public static void main(String[] args) {
        Leetcode_213_35 lc=new Leetcode_213_35();

        System.out.println(lc.rob(new int[]{2,3,2}));

        System.out.println(lc.rob(new int[]{1,2,3,1}));


    }

    /**
     * 思路分析：这个题目是在打家劫舍版本上面首位相连，也就是第一家和最后一家会连着的 那么把情况这两种情况单独拿出来看 1.第一家我可以偷，意味着最后那家就不能偷了
     * 2.第一家不偷，最后那家就可以偷 这里的偷和不偷只是要不要纳入本次迭代的考虑范围，求最优解的时候也不一定就一定会要偷
     *
     * 最后两种方案找个最好的结果就行
     */
    public int rob(int[] nums) {


        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }


        int[] dp1=new int[nums.length-1];

        dp1[0] = nums[0];
        dp1[1] = Math.max(dp1[0], nums[1]);

        //可以偷第一家,最后那家的不能偷，循环终止是nums.length-1
        for (int i = 2; i < nums.length-1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }



         //可以偷最后一家
        int[] dp2=new int[nums.length];
        dp2[0]=0;//第一家是强行不能偷
        dp2[1]=nums[1];

        for (int i=2;i<nums.length;i++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }


        return Math.max(dp1[nums.length - 2],dp2[nums.length - 1]);
    }


}

package com.leecode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 */
public class LeetCode_189_35 {
    public static void main(String[] args) {

        //考虑先移动一次的情况
        int nums[]={1,2,3,4,5};

        LeetCode_189_35 p189=new LeetCode_189_35();
        p189.rotate(nums,3);
        //p189.moveOnece(nums);

        System.out.println("最后结果:\n"+ Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        k%=nums.length;
        for(int i=0;i<k;i++){
            moveOnece(nums);
        }
    }

    /**
     * 移动一次
     * @param nums
     */
    public void moveOnece(int[] nums){
        int lastNum=nums[nums.length-1];
        for (int i=nums.length-1;i>0;i--){
            nums[i]=nums[i-1];
        }
        nums[0]=lastNum;
    }
}

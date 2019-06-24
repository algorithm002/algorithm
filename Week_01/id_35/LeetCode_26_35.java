package com.leecode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class LeetCode_26_35 {

    public static void main(String[] args) {
        //int[] nums={0,0,1,1,1,2,2,3,3,4};
        //int[] nums={1,1};
        int[] nums={1,2,2};
        System.out.println("原始数据:\n"+Arrays.toString(nums));
        System.out.println(removeDuplicates(nums));
        System.out.println("最后结果:\n"+Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[index]!=nums[i]){
                index++;
                nums[index]=nums[i+1];
            }
        }

        return index+1;
    }
}

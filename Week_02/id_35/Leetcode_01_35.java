package com.leecode.week02;

import java.util.*;

/**
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class Leetcode_01_35 {
    public static void main(String[] args) {
        Leetcode_01_35 lc=new Leetcode_01_35();
        int[] nums={2, 7, 11, 15};
        int target=9;
        System.out.println(Arrays.toString(lc.twoSum(nums,target)));
        System.out.println(Arrays.toString(lc.twoSum_v1(nums,target)));

    }


    /**
     * 确定了一个元素之后另一个元素其实也确定了,一次遍历过程中因为要通过下标访问，所以提取不到另一个元素
     * 思路:遍历之后把元素的位置缓存起来
     * @param nums
     * @param target
     * @return
     */
    public  int[] twoSum(int[] nums, int target){

        Map<Integer,Integer> cache=new HashMap<>();

        for (int i=0;i<nums.length;i++){
            int num=nums[i];
            int other=target-num;
            if(cache.keySet().contains(other)){
                return new int[]{cache.get(other),i};
            }else {
                cache.put(num,i);
            }
        }

        return null;
    }

    /**
     *两次遍历，先找到第一个元素，剩下的元素再接着找，时间复杂度是O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public  int[] twoSum_v1(int[] nums, int target) {
        int r1=-1,r2=-1;

        for(int i=0;i<nums.length;i++){
            r1=i;
            int other=target-nums[r1];

            for (int j=i+1;j<nums.length;j++){
                if(other==nums[j]){
                    r2=j;
                    break;
                }
            }

            if(r2!=-1){
                break;
            }

        }

        return  new int[]{r1,r2};
    }
}

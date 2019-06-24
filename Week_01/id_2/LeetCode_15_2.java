package com.llz.algorithm.algorithm2019.firstweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author liliangzi
 *
 */
public class LeetCode_15_2 {

	/**
	 * Output limit exceeded brutal force
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSumExceedOutputLimit(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[k] == -(nums[i] + nums[j]))
						list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
				}
			}
		}
		return list;
	}

	/**
	 * have referenced discussion
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		if ( nums.length > 0 && nums[0] > 0)
			return list;
		int lowPtr = 0, highPtr = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int val = -nums[i];
				lowPtr = i + 1;
				highPtr = nums.length - 1;
				while (lowPtr < highPtr) {
					if (nums[lowPtr] + nums[highPtr] == val) {
						list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[lowPtr], nums[highPtr])));
						while (lowPtr < highPtr && nums[lowPtr] == nums[lowPtr + 1])
							lowPtr++;
						while (lowPtr < highPtr && nums[highPtr] == nums[highPtr - 1])
							highPtr--;
						lowPtr++;
						highPtr--;
					} else if (nums[lowPtr] + nums[highPtr] < val) {
						while (lowPtr < highPtr && nums[lowPtr] == nums[lowPtr + 1])
							lowPtr++;
						lowPtr++;
					} else  {
						while (lowPtr < highPtr && nums[highPtr] == nums[highPtr - 1])
							highPtr--;
						highPtr--;
					}
				}
			}
		}
		return list;
	}

	static Random random = new Random();

	public static void main(String[] args) {
		int n = random.nextInt(15) + 1;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				nums[i] = -random.nextInt(15);
			else
				nums[i] = random.nextInt(15);
		}
		LeetCode_15_2 threeSum = new LeetCode_15_2();
		int[] nums1 = { -7, 4, -5, 12, -5, 14, -12, 10, -4, 12, -9, 0, -9 };
		int[] nums2 = { 0, 0, 0 };
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i] + " ");
		}
		System.out.println();
		List<List<Integer>> list = threeSum.threeSum(nums2);
		System.out.println(list);
	}

}

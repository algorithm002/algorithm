package com.github.lifelab.leetcode.problemset;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集 @see https://leetcode-cn.com/problems/subsets/
 *
 * @author Weichao Li (liweichao0102@gmail.com)
 * @since 2019-06-30
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new LinkedList<>();
        traverse(nums, 0, list, new LinkedList<>());
        return list;

    }

    private void traverse(int[] nums, int index, List<List<Integer>> list, List<Integer> currentList) {

        // terminator
        if (nums.length == index) {
            list.add(currentList);
            return;
        }

        // process & drill down
        List<Integer> target = new LinkedList<>(currentList);

        target.add(nums[index]);

        traverse(nums, index + 1, list, currentList);

        traverse(nums, index + 1, list, target);
    }
}
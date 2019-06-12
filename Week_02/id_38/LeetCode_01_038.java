import java.util.*;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class LeetCode_01_038 {
    public int[] twoSum(int[] nums, int target) {
        // hashmap, 时间 O(n),空间 O(n)
        Map<Integer, Integer> numDic = new HashMap<Integer, Integer>();
        // push and process
        for (int i = 0; i < nums.length; ++i) {
            if (numDic.containsKey(target - nums[i]) 
                && numDic.get(target - nums[i]) != i) {
                return new int[]{numDic.get(target - nums[i]), i};
            }
            numDic.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum1(int[] nums, int target) {
        // hashmap, 时间 O(2n),空间 O(n)
        Map<Integer, Integer> numDic = new HashMap<Integer, Integer>();
        // push
        for (int i = 0; i < nums.length; ++i) {
            numDic.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            if (numDic.containsKey(target - nums[i]) 
                && numDic.get(target - nums[i]) != i) {
                return new int[]{i, numDic.get(target - nums[i])};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        // 暴力，时间 O(n^2)，空间 O(1)
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        LeetCode_01_038 testCode_01_038 = new LeetCode_01_038();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] result = testCode_01_038.twoSum2(nums, 3);
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + ",");
        }
    }
}


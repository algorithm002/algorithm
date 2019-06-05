import java.util.*;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 * 要点1:答案中不包含重复的三元组
 */
class LeetCode_15_038 {
    /**
     * 暴力破解
     * 时间：O(n^2)
     * 结果：WA
     * 原因：结果中出现了重复的三元组
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> hitnums = new ArrayList<Integer>();
                        hitnums.add(nums[i]);
                        hitnums.add(nums[j]);
                        hitnums.add(nums[k]);
                        result.add(hitnums);
                    }
                }
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        LeetCode_15_038 testCode_15_038 = new LeetCode_15_038();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(testCode_15_038.threeSum(nums));
    }
}


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

        List<List<Integer>> result = new ArrayList<>();

        if (nums[0] <= 0 && nums[nums.length - 1] >= 0) {
            for (int i = 0; i < nums.length - 2; ++i) {
                if (i > 0 && nums[i-1] == nums[i]) continue;

                int l = i +1, r = nums.length - 1;
                while(l < r){
                    if(nums[r] > -nums[i]-nums[l]){
                        while(l < r && nums[r-1] == nums[r]) r--; //右指针去重
                        r--;
                    }
                    else if(nums[r] < -nums[i]-nums[l]){
                        while(l < r && nums[l+1] == nums[l]) l++; //左指针去重
                        l++;
                    }
                    else{
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while(l < r && nums[r-1] == nums[r]) r--; //左指针去重
                        while(l < r && nums[l+1] == nums[l]) l++; //右指针去重
                        r--;
                        l++;
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


/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 * 要点1:有序数组
 * 要点2:原地删除
 */
class LeetCode_26_038 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：不需要额外空间
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // check valid
        if (nums.length == 0) return 0;

        // process
        int i = 0;
        for (int j = 1; j < nums.length; ++j){
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        LeetCode_26_038 testCode_26_038 = new LeetCode_26_038();
        int[] nums = new int[]{1, 1, 2, 2, 4, 5, 7};
        System.out.println(testCode_26_038.removeDuplicates(nums));
    }
}


/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 * 要点1:有序数组
 * 要点2:原地删除
 */
class LeetCode_26_038 {

    /** 
     * 不考虑原地删除的情况，只求新数组的长度
     * 写出来发现真是又臭又长
     */
    public int removeDuplicates2(int[] nums) {
        // 检查数据
        if (nums.length == 0) {
            return 0;
        }

        // 处理
        int tmp = nums[0];
        int[] newnums = new int[nums.length];
        newnums[0] = tmp;
        int newnumsLength = 1;
        for (int i = 1; i <  nums.length; ++i) {
            if (tmp != nums[i]) {
                newnums[newnumsLength] = nums[i];
                newnumsLength++;
            } 
            tmp = nums[i];
        }

        for(int i = 0; i < newnums.length; ++i) {
            System.out.print(newnums[i] + ",");
        }

        return newnumsLength;
    }

    public int removeDuplicates(int[] nums) {
        // check valid
        if (nums.length == 0) {
            return 0;
        }
        // process
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            } 
        }
        return i+1;    
    }

    public static void main(String[] args) {
        LeetCode_26_038 testCode_26_038 = new LeetCode_26_038();
        int[] nums = new int[]{1, 1, 2, 2, 3};
        int newnumsLength = testCode_26_038.removeDuplicates2(nums);
        System.err.println(newnumsLength);

        int i = 0;
        for (; i < 5; ++i) {
            System.out.println("i=" + i);
        }
        System.out.println(" at last i=" + i);
    }
}


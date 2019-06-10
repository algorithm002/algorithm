package Week_01.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/3 19:25
 */
public class LeetCode_26_18 {
    public int removeDuplicates(int[] nums) {
        int nonDuplicatesIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            nums[nonDuplicatesIndex++] = nums[i];
        }

        return nonDuplicatesIndex;
    }
}

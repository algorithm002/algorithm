package Week_02.id_18;

/**
 * @author LiveForExperience
 * @date 2019/6/11 13:33
 */
public class LeetCode_1_18 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }

        return new int[2];
    }
}

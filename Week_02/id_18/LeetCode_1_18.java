package Week_02.id_18;

import java.util.HashMap;
import java.util.Map;

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

    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j) && i != map.get(j)) {
                return new int[]{i, map.get(j)};
            }
        }

        return new int[2];
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{i, map.get(j)};
            }
            map.put(nums[i], i);
        }

        return new int[2];
    }
}

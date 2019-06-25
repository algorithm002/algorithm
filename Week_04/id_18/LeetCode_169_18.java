package Week_04.id_18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiveForExperience
 * @date 2019/6/25 19:16
 */
public class LeetCode_169_18 {
    public static int majorityElement(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        int len = nums.length / 2;
        for (Integer num: nums) {
            map.compute(num, (k, v) -> v == null ? 1 : v++);
            if (map.get(num) > len) {
                return num;
            }
        }
        return 0;
    }

    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

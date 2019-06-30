package week01;

import java.util.HashMap;
import java.util.Map;

/**
 * Auth:luoxiang
 * Time:2019/6/30 5:31 PM
 * Desc:    求众数
 */
public class LeetCode_169_1 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_169_1().majorityElement(new int[]{3,2,3}));
        System.out.println(new LeetCode_169_1().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int temp = map.getOrDefault(num, 0) + 1;
            if (temp <= (nums.length / 2)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                return num;
            }

        }
        throw new IllegalArgumentException("异常");
    }
}

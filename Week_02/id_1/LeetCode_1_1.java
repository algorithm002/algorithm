package week02;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/11  11:50
 * @描述 LeetCode : 1. 两数之和      https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum1 {

    public static void main(String[] args) {
        final TwoSum1 twoSum1 = new TwoSum1();
        int[] i = twoSum1.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i1 : i) {
            System.out.println(i1);
        }
    }

    /**
     * Method 1 : 暴力法 ，两层循环
     * 时间复杂度 ： O(N*N)  ;   空间复杂度 ： O(1)    ；
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No result");
    }

    /**
     * Method 2 : 利用 Map 记忆储存法 ，把循环中没有匹配的值存储进 map当中，后面循环时进行判断，map 匹配成功 即返回
     *  时间复杂度 ： O(N)
     *  空间复杂度 ： O(N)
     */
    public int[] twoSum2(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int temp = target - nums[i];
            if (map.containsKey(temp)) return new int[]{map.get(temp), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No result");
    }

}

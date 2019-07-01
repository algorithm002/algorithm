package Week_04.id_18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiveForExperience
 * @date 2019/6/25 19:16
 */
public class LeetCode_169_18 {
    public int majorityElement(int[] nums) {
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

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int [] nums) {
        return divideConquer(nums, 0, nums.length - 1);
    }

    private int divideConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (right - left) / 2 + left;
        int leftMajorityNum = divideConquer(nums, left, mid);
        int rightMajorityNum = divideConquer(nums, mid + 1, right);

        if (leftMajorityNum == rightMajorityNum) {
            return leftMajorityNum;
        }

        long leftCount = count(nums, leftMajorityNum, left, mid);
        long rightCount = count(nums, rightMajorityNum, mid + 1, right);

        return leftCount > rightCount ? leftMajorityNum : rightMajorityNum;
    }

    private int count(int[] nums, int num,  int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}

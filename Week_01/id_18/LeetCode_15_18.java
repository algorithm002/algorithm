package Week_01.id_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LiveForExperience
 * @date 2019/6/9 19:23
 */
public class LeetCode_15_18 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int pointer = 0, head, tail, target;
        while (pointer < nums.length - 2) {
            if (pointer > 0 && nums[pointer] == nums[pointer - 1]) {
                pointer++;
                continue;
            }

            head = pointer + 1;
            tail = nums.length - 1;
            target = -nums[pointer];

            while (head < tail) {
                if (nums[head] + nums[tail] == target) {
                    result.add(Arrays.asList(nums[pointer], nums[head], nums[tail]));

                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }

                    while (head < tail && nums[tail - 1] == nums[tail]) {
                        tail--;
                    }

                    head++;
                    tail--;
                } else if (nums[head] + nums[tail] < target) {
                    head++;
                } else {
                    tail--;
                }
            }

            pointer++;
        }

        return result;
    }
}

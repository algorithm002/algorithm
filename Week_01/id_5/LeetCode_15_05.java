import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15_05 {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            if(nums[i]>0)
                break;
            int first = i + 1;
            int last = length - 1;
            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    first++;
                    last--;
                    while (first < last && nums[first] == nums[first - 1])
                        first++;
                    while (first < last && nums[last] == nums[last + 1])
                        last--;
                } else if (sum > 0&&first<last) {
                    last--;
                } else if (sum < 0 && first < last) {
                    first++;
                }
            }
        }
        return lists;
    }

}

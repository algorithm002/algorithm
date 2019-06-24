import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_05 {

    /**
     * 两数之和
     * - 做这个题的时候，已经做了三数之和了。
     * - 那我就不再使用枚举的方法了
     * -
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> book = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            int resultNum = target - nums[i];
            if (book.containsKey(resultNum)){
                return new int[]{book.get(resultNum),i};
            }
            book.put(nums[i],i);
        }
       return null;
    }


}

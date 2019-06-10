package week01;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/6  10:20
 * @描述     LeetCode: 1. 两数之和    https://leetcode-cn.com/problems/two-sum/
 */
public class TwoNum {
    public static void main(String[] args) {
        final TwoNum twoNum = new TwoNum();
        int[] nums={3, 2, 4};
        final int[] ints = twoNum.twoSum2(nums, 6);
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }
    }

    /**
     * Method 1 : 暴力法， 两层循环解决
     *  时间复杂度： O(N*N) ; 空间复杂度： O(N)
     *
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target-nums[i]==nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[1];
    }

    /**
     * Method 2 :  使用Map来进行存储，key: 数组下标 ； value: 数组下标对应的值； 循环一遍，并把值存储到map中，后面的循环来进行比较；
     *  时间复杂度： O(N) ;  空间复杂度： O(N) ；
     */
    public int[] twoSum2(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    }

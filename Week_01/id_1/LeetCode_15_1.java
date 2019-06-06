package week01;

import java.util.*;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/5  16:34
 * @描述 LeerCode :  15. 三数之和 ; https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        final ThreeSum threeSum = new ThreeSum();
        int[] ints = {-1, 0, 1};
        int[] int2 = {-1, 0, 1, 2, -1, -4};
        int[] int3 = {0, 0, 0, 0};
        int[] int4 = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        final List<List<Integer>> lists = threeSum.threeSum(ints);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        final List<List<Integer>> lists2 = threeSum.threeSum(int2);
        for (List<Integer> list : lists2) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        final List<List<Integer>> lists3 = threeSum.threeSum(int3);
        for (List<Integer> list : lists3) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        final List<List<Integer>> lists4 = threeSum.threeSum(int4);
        for (List<Integer> list : lists4) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
        System.out.println("----------------33333-------");
        final List<List<Integer>> lists5 = threeSum.threeSum3(int4);
        for (List<Integer> list : lists5) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }


    /**
     * Method 1: 暴力法; 3 层循环  ——>  超时了......
     * 时间复杂度 ： O(N*N*N+NlogN)   ;  空间复杂度 : O(N)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 1 && nums[i] + nums[j] <= 0; j++) {
                    if ( nums[j] != nums[j + 1]) {
                        for (int k = j + 1; k < nums.length; k++) {
//                    if (k > 2 && nums[k] == nums[k - 1]) continue;
                            if (nums[i] + nums[j] + nums[k] == 0) {
                                List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                                lists.add(list);
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }

    /**
     * 寻找新的解决方法
     * Method 3 : 排序后 ，再循环里面 ，从两边往中间 查找
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {


                int left = i + 1, right = nums.length - 1, needValue = 0 - nums[i];
                while (left < right) {
                    if (needValue == (nums[left] + nums[right])) {
                        if (!lists.contains(Arrays.asList(nums[i], nums[left], nums[right]))) {
                            lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        }
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    } else if (needValue < (nums[left] + nums[right])) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return lists;
    }

}

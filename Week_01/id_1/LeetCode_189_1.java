package week01;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/4  9:41
 * @描述 LeetCode:189. 旋转数组  https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {
    public static void main(String[] args) {
        final RotateArray rotateArray = new RotateArray();
        int[] nums = new int[]{-1, -100, 3, 99};
        rotateArray.rotate(nums, 2);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    /**
     * Function one :
     * k,两层循环， 第一层 数组 array; 第二层 k,要移动的位置
     * array[i] = array[length -1 ]
     * 时间复杂度 : O(k*n)
     * 空间复杂度 ： O(1)
     */
    public static void rotate1(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return;
        }
        int n = nums.length;
        k %= n;
        for (int j = 1; j <= k; j++) {
            int tempLast = nums[n - 1];
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tempLast;
        }
    }

    /**
     * Function two:
     * 反转的思路:
     * 第一次： 全部反转 一遍
     * 接下来以 k 为节点 进行区分         reverse(nums,0,n-1)
     * 第二次： k 之前的 数据反转一遍         reverse(nums,0,k-1)
     * 第三次： k 之后的 数据也要反转一遍     reverse(nums,k,n-1)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k %= n;
        reserve(nums,0,n-1);
        reserve(nums,0,k-1);
        reserve(nums,k,n-1);
    }

    private void reserve(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}

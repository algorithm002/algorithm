package week01;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/3  18:00
 * @描述
 */
public class ArrayMain {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    /***
     * 26. 删除排序数组中的重复项  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * @param nums
     * @return
     * 要求 O(1) 的额外空间实现
     * 思路：
     *      因为是排序好的数组，临时变量 count=0, temp=nums[0],后一个就跟temp 比较是否相等，不相等 则 count++，temp=nums[i];
     *
     *结论: 用两个临时变量，一个用来计数，一个用来保存上一个不相等的值；
     */
    public static int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        int count=0;
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            if(temp!=nums[i]){
                count++;
                temp=nums[i];
                nums[count]=nums[i];
            }
        }
        return count+1;
    }

    /***
     * 26. 删除排序数组中的重复项  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * @param nums
     * @return
     * 要求 O(1) 的额外空间实现
     * 思路：
     *      基于上面的思路， 临时变量 temp == nums[count] ; 所以temp 有点多余，可以直接用 nums[count] 与最新元素 来判断是否相等
     *
     */
    public static int removeDuplicates2(int[] nums) {
        if(nums.length == 0) return 0;
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[count]!=nums[i]){
                count++;
                nums[count]=nums[i];
            }
        }
        return count+1;
    }
}

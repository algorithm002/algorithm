package week01;

import java.util.Arrays;

/**
 * @创建人 luoxiang
 * @创建时间 2019/6/4  14:55
 * @描述 LeetCode : 88. 合并两个有序数组  https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray array = new MergeSortedArray();
        int[] a1 = new int[]{ 2, 3,4, 0, 0, 0};
        int[] a2 = new int[]{3, 5, 6};
        int m = 3;
        int n = 3;
        array.merge3(a1, m, a2, n);
        for (int i : a1) {
            System.out.print(i + ",");
        }
    }

    // 方法1： 第二个数组 插入 第一个数组； 再对第一个数组进行排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0 || nums1.length == 0) {
            return;
        }
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        for (int i : nums1) {
            System.out.print(i + ",");
        }
    }

    // 方法2： 从前往后 进行合并
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int newP = 0;
        while (p1 < m && p2 < n) {
            nums1[newP++] = (nums1Copy[p1] < nums2[p2] ? nums1Copy[p1++] : nums2[p2++]);
        }
        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m - p1);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, n - p2);
        }
    }

    // 方法3 ：  从后往前 进行合并
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        int p1 = m - 1;
        int p2 = n - 1;
        int newP = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[newP--] = (nums1[p1] > nums2[p2] ? nums1[p1--] :nums2[p2--]);
        }
        if(p2>=0){
            System.arraycopy(nums2,0,nums1,0,p2+1);
        }
    }


}

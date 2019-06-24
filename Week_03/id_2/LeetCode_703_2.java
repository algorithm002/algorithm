package com.llz.algorithm.algorithm2019.thirdweek;

import java.util.PriorityQueue;

public class LeetCode_703_2 {

    /**
     * Time complexity is O(nlogn) for building a min heap.
     * Space  complexity is O(n).
     */
    class KthLargest {

        private int k;
        private int[] nums;
        private PriorityQueue<Integer> pq;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.nums = nums;
            pq = new PriorityQueue(k);
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            if (pq.size() < k)
                pq.add(val);
            else {
                if (val > pq.peek()) {
                    pq.poll();
                    pq.add(val);
                }
            }
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        //[[1,[]],[-3],[-2],[-4],[0],[4]]
        //[[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
        LeetCode_703_2.KthLargest k = new LeetCode_703_2().new KthLargest(3, nums);
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }
}